package org.jetbrains.array.operations.tree

abstract class ArrayOperationsVisitor<out R, in D> {
    abstract fun visitPiece(piece: Piece, data: D): R

    open fun visitChain(chain: Chain, data: D): R {
        return visitPiece(chain, data)
    }

    open fun visitCall(call: Call, data: D): R {
        return visitPiece(call, data)
    }

    open fun visitFilterCall(filterCall: FilterCall, data: D): R {
        return visitCall(filterCall, data)
    }

    open fun visitMapCall(mapCall: MapCall, data: D): R {
        return visitCall(mapCall, data)
    }

    open fun visitExpression(expression: Expression, data: D): R {
        return visitPiece(expression, data)
    }

    open fun visitNumber(number: Number, data: D): R {
        return visitExpression(number, data)
    }

    open fun visitElement(element: Element, data: D): R {
        return visitExpression(element, data)
    }

    open fun visitBinaryExpression(binaryExpression: BinaryExpression, data: D): R {
        return visitExpression(binaryExpression, data)
    }

    open fun visitBooleanExpression(booleanExpression: BooleanExpression, data: D): R {
        return visitBinaryExpression(booleanExpression, data)
    }

    open fun visitLessExpression(lessExpression: LessExpression, data: D): R {
        return visitBooleanExpression(lessExpression, data)
    }

    open fun visitEqualsExpression(equalsExpression: EqualsExpression, data: D): R {
        return visitBooleanExpression(equalsExpression, data)
    }

    open fun visitMoreExpression(moreExpression: MoreExpression, data: D): R {
        return visitBooleanExpression(moreExpression, data)
    }

    open fun visitOrExpression(orExpression: OrExpression, data: D): R {
        return visitBooleanExpression(orExpression, data)
    }

    open fun visitAndExpression(andExpression: AndExpression, data: D): R {
        return visitBooleanExpression(andExpression, data)
    }

    open fun visitArithmeticExpression(arithmeticExpression: ArithmeticExpression, data: D): R {
        return visitBinaryExpression(arithmeticExpression, data)
    }

    open fun visitPlusExpression(plusExpression: PlusExpression, data: D): R {
        return visitArithmeticExpression(plusExpression, data)
    }

    open fun visitMinusExpression(minusExpression: MinusExpression, data: D): R {
        return visitArithmeticExpression(minusExpression, data)
    }

    open fun visitMultExpression(multExpression: MultExpression, data: D): R {
        return visitArithmeticExpression(multExpression, data)
    }

    open fun visitOperator(operator: Operator, data: D): R {
        return visitPiece(operator, data)
    }

    open fun visitBooleanOperator(booleanOperator: BooleanOperator, data: D): R {
        return visitOperator(booleanOperator, data)
    }

    open fun visitLessOperator(lessOperator: LessOperator, data: D): R {
        return visitBooleanOperator(lessOperator, data)
    }

    open fun visitEqualsOperator(equalsOperator: EqualsOperator, data: D): R {
        return visitBooleanOperator(equalsOperator, data)
    }

    open fun visitMoreOperator(moreOperator: MoreOperator, data: D): R {
        return visitBooleanOperator(moreOperator, data)
    }

    open fun visitOrOperator(orOperator: OrOperator, data: D): R {
        return visitBooleanOperator(orOperator, data)
    }

    open fun visitAndOperator(andOperator: AndOperator, data: D): R {
        return visitBooleanOperator(andOperator, data)
    }

    open fun visitArithmeticOperator(arithmeticOperator: ArithmeticOperator, data: D): R {
        return visitOperator(arithmeticOperator, data)
    }

    open fun visitPlusOperator(plusOperator: PlusOperator, data: D): R {
        return visitArithmeticOperator(plusOperator, data)
    }

    open fun visitMinusOperator(minusOperator: MinusOperator, data: D): R {
        return visitArithmeticOperator(minusOperator, data)
    }

    open fun visitMultOperator(multOperator: MultOperator, data: D): R {
        return visitArithmeticOperator(multOperator, data)
    }
}