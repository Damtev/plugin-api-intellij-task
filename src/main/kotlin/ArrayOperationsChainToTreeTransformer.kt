import org.antlr.v4.runtime.*
import org.antlr.v4.runtime.tree.TerminalNode
import org.jetbrains.array.operations.ArrayOperationsGrammarLexer
import org.jetbrains.array.operations.ArrayOperationsGrammarParser
import org.jetbrains.array.operations.ArrayOperationsGrammarParser.*
import org.jetbrains.array.operations.tree.*
import org.jetbrains.array.operations.tree.Number

class ArrayOperationsChainToTreeTransformer {
    fun transform(sourceFileName: String): Chain {
        val lexer = ArrayOperationsGrammarLexer(CharStreams.fromFileName(sourceFileName))
        lexer.removeErrorListeners()
        lexer.addErrorListener(ThrowingErrorListener)
        val tokens = CommonTokenStream(lexer)

        val parser = ArrayOperationsGrammarParser(tokens)
        parser.removeErrorListeners()
        return parser.call_chain().transform(arrayListOf())
    }

    private fun Call_chainContext.transform(calls: ArrayList<CallContext>): Chain {
        val call = call()
        val next: TerminalNode? = NEXT()
        val hasNext = next != null
        calls.add(call)
        if (hasNext) {
            return (this.children[2] as Call_chainContext).transform(calls)
        }
        return Chain(calls.map { it.transform() } as ArrayList<Call>)
    }

    private fun CallContext.transform(): Call {
        val filterCallContext: Filter_callContext? = filter_call()
        val mapCallContext: Map_callContext? = map_call()
        return when {
            filterCallContext != null -> filterCallContext.transform()
            mapCallContext != null -> mapCallContext.transform()
            else -> throw IllegalStateException()
        }
    }

    private fun Filter_callContext.transform(): FilterCall {
        val exprContext = expr()
        val expression = exprContext.transform()
        if (expression !is BooleanExpression) {
            throw InvalidTypeException()
        }
        return FilterCall(expression)
    }

    private fun Map_callContext.transform(): MapCall {
        val exprContext = expr()
        val expression = exprContext.transform()
        if (expression is BooleanExpression) {
            throw InvalidTypeException()
        }
        return MapCall(expression)
    }

    private fun ExprContext.transform(): Expression {
        val element: TerminalNode? = ELEMENT()
        val number: TerminalNode? = NUMBER()
        val binaryExprContext: Binary_exprContext? = binary_expr()
        return when {
            element != null -> Element()
            number != null -> Number(number.text.toInt())
            binaryExprContext != null -> binaryExprContext.transform()
            else -> throw IllegalStateException()
        }
    }

    private fun Binary_exprContext.transform(): BinaryExpression {
        val lhs = expr(0).transform()
        val operator = binary_operation().transform()
        val rhs = expr(1).transform()
        return when (operator) {
            is BooleanOperator -> {
                if (operator is OrOperator || operator is AndOperator) {
                    if (lhs !is BooleanExpression || rhs !is BooleanExpression) {
                        throw InvalidTypeException()
                    }
                } else {
                    if (lhs is BooleanExpression || rhs is BooleanExpression) {
                        throw InvalidTypeException()
                    }
                }
                when (operator) {
                    is LessOperator -> LessExpression(lhs, operator, rhs)
                    is EqualsOperator -> EqualsExpression(lhs, operator, rhs)
                    is MoreOperator -> MoreExpression(lhs, operator, rhs)
                    else -> throw IllegalStateException()
                }
            }
            is ArithmeticOperator -> {
                if (lhs is BooleanExpression || rhs is BooleanExpression) {
                    throw InvalidTypeException()
                }
                when (operator) {
                    is PlusOperator -> PlusExpression(lhs, operator, rhs)
                    is MinusOperator -> MinusExpression(lhs, operator, rhs)
                    is MultOperator -> MultExpression(lhs, operator, rhs)
                }
            }
        }
    }

    private fun Binary_operationContext.transform(): Operator {
        val plus: TerminalNode? = PLUS()
        val minus: TerminalNode? = MINUS()
        val mult: TerminalNode? = MULT()
        val less: TerminalNode? = LESS()
        val equals: TerminalNode? = EQUALS()
        val more: TerminalNode? = GREATER()
        val or: TerminalNode? = OR()
        val and: TerminalNode? = AND()
        return when {
            plus != null -> PlusOperator()
            minus != null -> MinusOperator()
            mult != null -> MultOperator()
            less != null -> LessOperator()
            equals != null -> EqualsOperator()
            more != null -> MoreOperator()
            or != null -> OrOperator()
            and != null -> AndOperator()
            else -> throw IllegalStateException()
        }
    }

    private object ThrowingErrorListener : BaseErrorListener() {
        override fun syntaxError(
            recognizer: Recognizer<*, *>?,
            offendingSymbol: Any?,
            line: Int,
            charPositionInLine: Int,
            msg: String?,
            e: RecognitionException?
        ) {
            throw InvalidSyntaxException()
        }
    }

    class InvalidTypeException : Exception("TYPE ERROR") {}

    class InvalidSyntaxException : Exception("SYNTAX ERROR") {}
}