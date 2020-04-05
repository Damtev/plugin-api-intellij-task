import org.jetbrains.array.operations.tree.*

// The main idea is to transform pair map-filter to pair filter-map until there is no such pairs,
// so in the result where will be chain (filter_call)*(map_call)*, then combine all filters to one and all maps to one,
// so it will be filter_call-map_call, as needed
fun Chain.transform(): Chain {
    val res = this
    if (res.calls.size == 1) {
        when (res.calls.first()) {
            is FilterCall -> res.calls.add(MapCall(Element()))
            is MapCall -> {
                res.calls.add(res.calls.first())
                res.calls[0] = FilterCall(EqualsExpression(Element(), EqualsOperator(), Element()))
            }
        }

        return res
    }

    val calls = res.calls
    val len = calls.size
    while (true) {
        var hasMapFilterPair = false
        for (i in 0 until len - 1) {
            val curCall = calls[i]
            val nextCall = calls[i + 1]
            if (curCall is MapCall && nextCall is FilterCall) {
                calls[i] = FilterCall(nextCall.expression.substitute(curCall.expression) as BooleanExpression)
                calls[i + 1] = curCall
                hasMapFilterPair = true
            }
        }
        if (!hasMapFilterPair) {
            break
        }
    }
    // now chain is (filter)*(map)*, and size > 1
    val filterCalls = calls.takeWhile { it is FilterCall } as List<FilterCall>
    val filterCall = filterCalls.combine()

    val mapCalls = calls.takeLastWhile { it is MapCall } as List<MapCall>
    val mapCall = mapCalls.combine()

    val resultCalls = arrayListOf<Call>(filterCall, mapCall)
    return Chain(resultCalls)
}

fun List<FilterCall>.combine(): FilterCall {
    if (this.isEmpty()) {
        return FilterCall(EqualsExpression(Element(), EqualsOperator(), Element()))
    }

    var res = this[0].expression
    for (i in 1 until this.size) {
        res = AndExpression(res, AndOperator(), this[i].expression)
    }

    return FilterCall(res)
}

fun List<MapCall>.combine(): MapCall {
    if (this.isEmpty()) {
        return MapCall(Element())
    }

    var res = this[0].expression
    for (i in 1 until this.size) {
        res = this[i].expression.substitute(res)
    }

    return MapCall(res)
}