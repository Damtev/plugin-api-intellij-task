import org.jetbrains.array.operations.tree.*
import org.jetbrains.array.operations.tree.Number
import kotlin.math.abs

class Polynom(var degree: Int, var coefficients: IntArray) {

    operator fun plus(polynom: Polynom): Polynom {
        return if (polynom.degree > degree) {
            plusOrMinus(polynom.degree, degree, polynom.coefficients, coefficients, Int::plus)
        } else {
            plusOrMinus(degree, polynom.degree, coefficients, polynom.coefficients, Int::plus)
        }
    }

    operator fun minus(polynom: Polynom): Polynom {
        return if (polynom.degree > degree) {
            plusOrMinus(polynom.degree, degree, polynom.coefficients, coefficients) { a: Int, b: Int -> -(a - b) }
        } else {
            plusOrMinus(degree, polynom.degree, coefficients, polynom.coefficients, Int::minus)
        }
    }

    operator fun times(polynom: Polynom): Polynom {
        return if (polynom.degree > degree) {
            mult(polynom.degree, degree, polynom.coefficients, coefficients)
        } else {
            mult(degree, polynom.degree, coefficients, polynom.coefficients)
        }
    }

    private fun plusOrMinus(
        maxDegree: Int,
        minDegree: Int,
        maxArray: IntArray,
        minArray: IntArray,
        binOp: (Int, Int) -> Int
    ): Polynom {
        val extendedMinArray =
            IntArray(maxDegree + 1) { if (it < (maxDegree - minDegree)) 0 else minArray[it - maxDegree + minDegree] }
        val result = IntArray(maxDegree + 1)
        for (i in 0..maxDegree) {
            result[i] = binOp(maxArray[i], extendedMinArray[i])
        }
        val polynom = Polynom(maxDegree, result)
        removeLeadingZeroes(polynom)
        return polynom
    }

    private fun mult(
        maxDegree: Int,
        minDegree: Int,
        maxArray: IntArray,
        minArray: IntArray
    ): Polynom {
        val extendedMinArray =
            IntArray(maxDegree + 1) { if (it < (maxDegree - minDegree)) 0 else minArray[it - maxDegree + minDegree] }
        val resultDegree = maxDegree * 2
        val result = IntArray(resultDegree + 1)
        for (i in 0..maxDegree) {
            for (j in 0..maxDegree) {
                result[i + j] += maxArray[i] * extendedMinArray[j]
            }
        }
        val polynom = Polynom(resultDegree, result)
        removeLeadingZeroes(polynom)
        return polynom
    }

    private fun removeLeadingZeroes(polynom: Polynom) {
        polynom.coefficients = polynom.coefficients.dropWhile { it == 0 }.toIntArray()
        if (polynom.coefficients.isEmpty()) {
            polynom.coefficients = intArrayOf(0)
        }
        polynom.degree = polynom.coefficients.size - 1
    }

    override fun toString(): String {
        var curDegree = degree - 1
        return coefficients.joinToString(separator = " + ", transform = { coeff ->
            coeffToString(coeff, curDegree--)
        })
    }

    private fun coeffToString(coeff: Int, curDegree: Int, elementToString: String = Element().toString()) =
        buildString {
            if (coeff != 0) {
                if (coeff != 1) {
                    append(coeff)
                    if (curDegree > 0) {
                        append(" * ")
                    }
                }
                if (curDegree > 0) {
                    append(Array(curDegree) { elementToString }.joinToString(separator = " * "))
                }
            }
        }

    fun toExpression(): Expression {
        var curDegree = degree
        val expressions = arrayListOf<Expression>()
        coefficients.forEach {
            if (it != 0) {
                if (curDegree == 0) {
                    expressions.add(Number(it))
                } else {
                    val number = Number(it)
                    var elements: Expression = Element()
                    repeat(curDegree - 1) {
                        elements = MultExpression(elements, MultOperator(), Element())
                    }
                    expressions.add(MultExpression(number, MultOperator(), elements))
                }
            }
            --curDegree
        }
        if (expressions.isEmpty()) {
            expressions.add(Number(0))
        }
        var result = expressions.first()
        if (result is MultExpression) {
            val number = (result.lhs as Number).value
            if (number == 1) {
                result = result.rhs
            }
        }
        for (i in 1 until expressions.size) {
            val curExpression = expressions[i]
            if (curExpression is Number) {
                result = if (curExpression.value < 0) {
                    MinusExpression(result, MinusOperator(), Number(abs(curExpression.value)))
                } else {
                    PlusExpression(result, PlusOperator(), curExpression)
                }
            } else { // MultExpression
                curExpression as MultExpression
                val num = (curExpression.lhs as Number).value
                result = if (num == 1 || num == -1) {
                    if (num == 1) {
                        PlusExpression(result, PlusOperator(), curExpression.rhs)
                    } else {
                        MinusExpression(result, MinusOperator(), curExpression.rhs)
                    }
                } else {
                    if (num > 0) {
                        PlusExpression(result, PlusOperator(), curExpression)
                    } else {
                        MinusExpression(
                            result,
                            MinusOperator(),
                            MultExpression(Number(abs(num)), MultOperator(), curExpression.rhs)
                        )
                    }
                }
            }
        }

        return result
    }
}