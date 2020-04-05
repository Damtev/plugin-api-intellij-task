import org.jetbrains.array.operations.tree.*
import org.jetbrains.array.operations.tree.Number

fun List<Int>.apply(chain: Chain): List<Int> {
    var res = this
    chain.calls.forEach { res = res.apply(it) }
    return res
}

fun List<Int>.apply(call: Call): List<Int> {
    return when (call) {
        is FilterCall -> this.apply(call)
        is MapCall -> this.apply(call)
    }
}

fun List<Int>.apply(filterCall: FilterCall): List<Int> {
    val filtered = arrayListOf<Int>()
    this.forEach { if (it.isTrue(filterCall.expression)) filtered.add(it) }
    return filtered
}

fun Int.isTrue(expression: Expression): Boolean {
    if (expression !is BooleanExpression) {
        throw ArrayOperationsChainToTreeTransformer.InvalidTypeException()
    }
    return when (expression) {
        is LessExpression -> {
            val left = this.substitute(expression.lhs)
            val right = this.substitute(expression.rhs)
            left < right
        }
        is EqualsExpression -> {
            val left = this.substitute(expression.lhs)
            val right = this.substitute(expression.rhs)
            left == right
        }
        is MoreExpression -> {
            val left = this.substitute(expression.lhs)
            val right = this.substitute(expression.rhs)
            left > right
        }
        is OrExpression -> {
            this.isTrue(expression.lhs) || this.isTrue(expression.rhs)
        }
        is AndExpression -> {
            this.isTrue(expression.lhs) && this.isTrue(expression.rhs)
        }
    }
}

fun Int.substitute(expression: Expression): Int {
    return when (expression) {
        is ArithmeticExpression -> {
            when (expression) {
                is PlusExpression -> {
                    val left = this.substitute(expression.lhs)
                    val right = this.substitute(expression.rhs)
                    left + right
                }
                is MinusExpression -> {
                    val left = this.substitute(expression.lhs)
                    val right = this.substitute(expression.rhs)
                    left - right
                }
                is MultExpression -> {
                    val left = this.substitute(expression.lhs)
                    val right = this.substitute(expression.rhs)
                    left * right
                }
            }
        }
        is Number -> expression.value
        is Element -> this
        else -> throw ArrayOperationsChainToTreeTransformer.InvalidTypeException()
    }
}

fun List<Int>.apply(mapCall: MapCall): List<Int> {
    val mapped = arrayListOf<Int>()
    this.forEach { mapped.add(it.substitute(mapCall.expression)) }
    return mapped
}

fun Expression.substitute(expression: Expression): Expression {
    return when (this) {
        is Number -> this
        is Element -> expression
        is BooleanExpression -> {
            when (this) {
                is LessExpression -> LessExpression(lhs.substitute(expression), operator, rhs.substitute(expression))
                is EqualsExpression -> EqualsExpression(lhs.substitute(expression), operator, rhs.substitute(expression))
                is MoreExpression -> MoreExpression(lhs.substitute(expression), operator, rhs.substitute(expression))
                is OrExpression -> OrExpression(lhs.substitute(expression), operator, rhs.substitute(expression))
                is AndExpression -> AndExpression(lhs.substitute(expression), operator, rhs.substitute(expression))
            }
        }
        is ArithmeticExpression -> {
            when (this) {
                is PlusExpression -> PlusExpression(lhs.substitute(expression), operator, rhs.substitute(expression))
                is MinusExpression -> MinusExpression(lhs.substitute(expression), operator, rhs.substitute(expression))
                is MultExpression -> MultExpression(lhs.substitute(expression), operator, rhs.substitute(expression))
            }
        }
    }
}