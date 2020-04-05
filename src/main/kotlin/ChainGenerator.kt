import org.jetbrains.array.operations.tree.*
import org.jetbrains.array.operations.tree.Number
import java.util.*
import kotlin.random.Random

const val CHAIN_MIN_LEN = 1
const val CHAIN_MAX_LEN = 7
const val CALL_TYPES = 2
const val BOOLEAN_EXPRESSION_TYPES = 5
const val MAP_EXPRESSION_TYPES = 5
const val MIN_NUMBER = -100
const val MAX_NUMBER = 100
const val MAX_BOOLEAN_EXPRESSIONS_AMOUNT = 3
const val MAX_MAP_EXPRESSIONS_AMOUNT = 3

var curBooleanExpressionsCount = 0
var curMapExpressionsCount = 0


fun generateChain(): Chain {
    val time = Calendar.getInstance().timeInMillis
    val len = Random(time).nextInt(CHAIN_MIN_LEN, CHAIN_MAX_LEN + 1)
    val calls = arrayListOf<Call>()
    repeat(len) {
        calls.add(generateCall())
        curBooleanExpressionsCount = 0
        curMapExpressionsCount = 0
    }
    return Chain(calls)
}

fun generateCall(): Call {
    val time = Calendar.getInstance().timeInMillis
    val typeOfCall = Random(time).nextInt(1, CALL_TYPES + 1)
    return when (typeOfCall) {
        1 -> generateFilterCall()
        else -> generateMapCall()
    }
}

fun generateFilterCall() = FilterCall(generateBooleanExpression())

fun generateMapCall() = MapCall(generateMapExpression())

fun generateBooleanExpression(): BooleanExpression {
    ++curBooleanExpressionsCount
    val max = if (curBooleanExpressionsCount > MAX_BOOLEAN_EXPRESSIONS_AMOUNT) 3 else BOOLEAN_EXPRESSION_TYPES
    return when (val booleanExpressionType = Random.nextInt(1, max + 1)) {
        1, 2, 3 -> {
            val lhs = generateMapExpression()
            val rhs = generateMapExpression()
            when (booleanExpressionType) {
                1 -> LessExpression(lhs, LessOperator(), rhs)
                2 -> EqualsExpression(lhs, EqualsOperator(), rhs)
                else -> MoreExpression(lhs, MoreOperator(), rhs)
            }
        }
        else -> {
            val lhs = generateBooleanExpression()
            val rhs = generateBooleanExpression()
            when (booleanExpressionType) {
                4 -> OrExpression(lhs, OrOperator(), rhs)
                else -> AndExpression(lhs, AndOperator(), rhs)
            }
        }
    }
}

fun generateMapExpression(): Expression {
    ++curMapExpressionsCount
    val max = if (curMapExpressionsCount > MAX_MAP_EXPRESSIONS_AMOUNT) 2 else MAP_EXPRESSION_TYPES
    return when (val mapExpressionType = Random.nextInt(1, max + 1)) {
        1 -> Number(Random.nextInt(MIN_NUMBER, MAX_NUMBER + 1))
        2 -> Element()
        else -> {
            val lhs = generateMapExpression()
            val rhs = generateMapExpression()
            when (mapExpressionType) {
                3 -> PlusExpression(lhs, PlusOperator(), rhs)
                4 -> MinusExpression(lhs, MinusOperator(), rhs)
                else -> MultExpression(lhs, MultOperator(), rhs)
            }
        }
    }
}