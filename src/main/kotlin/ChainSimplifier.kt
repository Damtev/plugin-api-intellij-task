import org.jetbrains.array.operations.tree.*
import org.jetbrains.array.operations.tree.Number

fun Chain.simplify(): Chain {
    val newCalls = arrayListOf<Call>()
    calls.forEach { newCalls.add(it.simplify()) }
    return Chain(newCalls)
}

fun Call.simplify(): Call {
    return when (this) {
        is FilterCall -> FilterCall(this.expression.simplify() as BooleanExpression)
        is MapCall -> MapCall(this.expression.simplify())
    }
}

fun Expression.simplify(): Expression {
    return when (this) {
        is Number, is Element -> this
        is BooleanExpression -> {
            when (this) {
                is LessExpression -> LessExpression(lhs.simplify(), LessOperator(), rhs.simplify())
                is EqualsExpression -> EqualsExpression(lhs.simplify(), EqualsOperator(), rhs.simplify())
                is MoreExpression -> MoreExpression(lhs.simplify(), MoreOperator(), rhs.simplify())
                is OrExpression -> OrExpression(lhs.simplify(), OrOperator(), rhs.simplify())
                is AndExpression -> AndExpression(lhs.simplify(), AndOperator(), rhs.simplify())
            }
        }
        is ArithmeticExpression -> {
            this.toPolynom().toExpression()
//            when (this) {
//                is PlusExpression -> {
//                    val left = lhs.simplify()
//                    val right = rhs.simplify()
//                    if (left is Number && right is Number) {
//                        Number(left.value + right.value)
//                    } else {
//                        if (left == right) {
//                            MultExpression(Number(2), MultOperator(), left)
//                        } else {
//                            PlusExpression(left, PlusOperator(), right)
//                        }
//                    }
//                }
//                is MinusExpression -> {
//                    val left = lhs.simplify()
//                    val right = rhs.simplify()
//                    if (left is Number && right is Number) {
//                        Number(left.value - right.value)
//                    } else {
//                        if (left == right) {
//                            Number(0)
//                        } else {
//                            MinusExpression(left, MinusOperator(), right)
//                        }
//                    }
//                }
//                is MultExpression -> {
//                    val left = lhs.simplify()
//                    val right = rhs.simplify()
//                    if (left is Number && right is Number) {
//                        Number(left.value * right.value)
//                    } else {
//                        MultExpression(left, MultOperator(), right)
//                    }
//                }
//            }
        }
    }
}