package org.jetbrains.array.operations.tree

import Polynom

const val NEXT = "%>%"
const val ELEMENT = "element"

sealed class Piece {
    abstract fun <R, D> accept(visitor: ArrayOperationsVisitor<R, D>, data: D): R
    abstract fun <D> acceptChildren(visitor: ArrayOperationsVisitor<*, D>, data: D)
}

class Chain(
    val calls: ArrayList<Call>
) : Piece() {
    override fun <R, D> accept(visitor: ArrayOperationsVisitor<R, D>, data: D): R {
        return visitor.visitChain(this, data)
    }

    override fun <D> acceptChildren(visitor: ArrayOperationsVisitor<*, D>, data: D) {
        calls.forEach { it.accept(visitor, data) }
    }

    override fun toString(): String {
        return calls.joinToString(NEXT)
    }
}

sealed class Call : Piece() {}

class FilterCall(
    var expression: BooleanExpression
) : Call() {
    override fun <R, D> accept(visitor: ArrayOperationsVisitor<R, D>, data: D): R {
        return visitor.visitFilterCall(this, data)
    }

    override fun <D> acceptChildren(visitor: ArrayOperationsVisitor<*, D>, data: D) {
        expression.accept(visitor, data)
    }

    override fun toString(): String {
        return "filter{$expression}"
    }
}

class MapCall(
    var expression: Expression
) : Call() {
    override fun <R, D> accept(visitor: ArrayOperationsVisitor<R, D>, data: D): R {
        return visitor.visitMapCall(this, data)
    }

    override fun <D> acceptChildren(visitor: ArrayOperationsVisitor<*, D>, data: D) {
        expression.accept(visitor, data)
    }

    override fun toString(): String {
        return "map{$expression}"
    }
}

sealed class Expression : Piece() {
    abstract fun toPolynom(): Polynom
}

class Number(
    var value: Int
) : Expression() {
    override fun <R, D> accept(visitor: ArrayOperationsVisitor<R, D>, data: D): R {
        return visitor.visitNumber(this, data)
    }

    override fun <D> acceptChildren(visitor: ArrayOperationsVisitor<*, D>, data: D) {}

    override fun toString(): String {
        return value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Number

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value
    }

    override fun toPolynom(): Polynom {
        return Polynom(0, intArrayOf(value))
    }
}

class Element(
    val value: String = ELEMENT
) : Expression() {
    override fun <R, D> accept(visitor: ArrayOperationsVisitor<R, D>, data: D): R {
        return visitor.visitElement(this, data)
    }

    override fun <D> acceptChildren(visitor: ArrayOperationsVisitor<*, D>, data: D) {}

    override fun toString(): String {
        return value
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Element

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    override fun toPolynom(): Polynom {
        return Polynom(1, intArrayOf(1, 0))
    }
}

sealed class BinaryExpression : Expression() {}

sealed class BooleanExpression : BinaryExpression() {}

class LessExpression(
    var lhs: Expression,
    var operator: LessOperator,
    var rhs: Expression
) : BooleanExpression() {
    override fun <R, D> accept(visitor: ArrayOperationsVisitor<R, D>, data: D): R {
        return visitor.visitLessExpression(this, data)
    }

    override fun <D> acceptChildren(visitor: ArrayOperationsVisitor<*, D>, data: D) {
        lhs.accept(visitor, data)
        operator.accept(visitor, data)
        rhs.accept(visitor, data)
    }

    override fun toString(): String {
        return "($lhs $operator $rhs)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LessExpression

        if (lhs != other.lhs) return false
        if (operator != other.operator) return false
        if (rhs != other.rhs) return false

        return true
    }

    override fun hashCode(): Int {
        var result = lhs.hashCode()
        result = 31 * result + operator.hashCode()
        result = 31 * result + rhs.hashCode()
        return result
    }

    override fun toPolynom(): Polynom {
        throw NoSuchMethodException()
    }
}

class EqualsExpression(
    var lhs: Expression,
    var operator: EqualsOperator,
    var rhs: Expression
) : BooleanExpression() {
    override fun <R, D> accept(visitor: ArrayOperationsVisitor<R, D>, data: D): R {
        return visitor.visitEqualsExpression(this, data)
    }

    override fun <D> acceptChildren(visitor: ArrayOperationsVisitor<*, D>, data: D) {
        lhs.accept(visitor, data)
        operator.accept(visitor, data)
        rhs.accept(visitor, data)
    }

    override fun toString(): String {
        return "($lhs $operator $rhs)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EqualsExpression

        if (lhs != other.lhs) return false
        if (operator != other.operator) return false
        if (rhs != other.rhs) return false

        return true
    }

    override fun hashCode(): Int {
        var result = lhs.hashCode()
        result = 31 * result + operator.hashCode()
        result = 31 * result + rhs.hashCode()
        return result
    }

    override fun toPolynom(): Polynom {
        throw NoSuchMethodException()
    }
}

class MoreExpression(
    var lhs: Expression,
    var operator: MoreOperator,
    var rhs: Expression
) : BooleanExpression() {
    override fun <R, D> accept(visitor: ArrayOperationsVisitor<R, D>, data: D): R {
        return visitor.visitMoreExpression(this, data)
    }

    override fun <D> acceptChildren(visitor: ArrayOperationsVisitor<*, D>, data: D) {
        lhs.accept(visitor, data)
        operator.accept(visitor, data)
        rhs.accept(visitor, data)
    }

    override fun toString(): String {
        return "($lhs $operator $rhs)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MoreExpression

        if (lhs != other.lhs) return false
        if (operator != other.operator) return false
        if (rhs != other.rhs) return false

        return true
    }

    override fun hashCode(): Int {
        var result = lhs.hashCode()
        result = 31 * result + operator.hashCode()
        result = 31 * result + rhs.hashCode()
        return result
    }

    override fun toPolynom(): Polynom {
        throw NoSuchMethodException()
    }
}

class OrExpression(
    var lhs: Expression,
    var operator: OrOperator,
    var rhs: Expression
) : BooleanExpression() {
    override fun <R, D> accept(visitor: ArrayOperationsVisitor<R, D>, data: D): R {
        return visitor.visitOrExpression(this, data)
    }

    override fun <D> acceptChildren(visitor: ArrayOperationsVisitor<*, D>, data: D) {
        lhs.accept(visitor, data)
        operator.accept(visitor, data)
        rhs.accept(visitor, data)
    }

    override fun toString(): String {
        return "($lhs $operator $rhs)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as OrExpression

        if (lhs != other.lhs) return false
        if (operator != other.operator) return false
        if (rhs != other.rhs) return false

        return true
    }

    override fun hashCode(): Int {
        var result = lhs.hashCode()
        result = 31 * result + operator.hashCode()
        result = 31 * result + rhs.hashCode()
        return result
    }

    override fun toPolynom(): Polynom {
        throw NoSuchMethodException()
    }
}

class AndExpression(
    var lhs: Expression,
    var operator: AndOperator,
    var rhs: Expression
) : BooleanExpression() {
    override fun <R, D> accept(visitor: ArrayOperationsVisitor<R, D>, data: D): R {
        return visitor.visitAndExpression(this, data)
    }

    override fun <D> acceptChildren(visitor: ArrayOperationsVisitor<*, D>, data: D) {
        lhs.accept(visitor, data)
        operator.accept(visitor, data)
        rhs.accept(visitor, data)
    }

    override fun toString(): String {
        return "($lhs $operator $rhs)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as AndExpression

        if (lhs != other.lhs) return false
        if (operator != other.operator) return false
        if (rhs != other.rhs) return false

        return true
    }

    override fun hashCode(): Int {
        var result = lhs.hashCode()
        result = 31 * result + operator.hashCode()
        result = 31 * result + rhs.hashCode()
        return result
    }

    override fun toPolynom(): Polynom {
        throw NoSuchMethodException()
    }
}

sealed class ArithmeticExpression : BinaryExpression() {}

class PlusExpression(
    var lhs: Expression,
    var operator: PlusOperator,
    var rhs: Expression
) : ArithmeticExpression() {
    override fun <R, D> accept(visitor: ArrayOperationsVisitor<R, D>, data: D): R {
        return visitor.visitPlusExpression(this, data)
    }

    override fun <D> acceptChildren(visitor: ArrayOperationsVisitor<*, D>, data: D) {
        lhs.accept(visitor, data)
        operator.accept(visitor, data)
        rhs.accept(visitor, data)
    }

    override fun toString(): String {
        return "($lhs $operator $rhs)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PlusExpression

        if (lhs != other.lhs) return false
        if (operator != other.operator) return false
        if (rhs != other.rhs) return false

        return true
    }

    override fun hashCode(): Int {
        var result = lhs.hashCode()
        result = 31 * result + operator.hashCode()
        result = 31 * result + rhs.hashCode()
        return result
    }

    override fun toPolynom(): Polynom {
        return lhs.toPolynom() + rhs.toPolynom()
    }
}

class MinusExpression(
    var lhs: Expression,
    var operator: MinusOperator,
    var rhs: Expression
) : ArithmeticExpression() {
    override fun <R, D> accept(visitor: ArrayOperationsVisitor<R, D>, data: D): R {
        return visitor.visitMinusExpression(this, data)
    }

    override fun <D> acceptChildren(visitor: ArrayOperationsVisitor<*, D>, data: D) {
        lhs.accept(visitor, data)
        operator.accept(visitor, data)
        rhs.accept(visitor, data)
    }

    override fun toString(): String {
        return "($lhs $operator $rhs)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MinusExpression

        if (lhs != other.lhs) return false
        if (operator != other.operator) return false
        if (rhs != other.rhs) return false

        return true
    }

    override fun hashCode(): Int {
        var result = lhs.hashCode()
        result = 31 * result + operator.hashCode()
        result = 31 * result + rhs.hashCode()
        return result
    }

    override fun toPolynom(): Polynom {
        return lhs.toPolynom() - rhs.toPolynom()
    }
}

class MultExpression(
    var lhs: Expression,
    var operator: MultOperator,
    var rhs: Expression
) : ArithmeticExpression() {
    override fun <R, D> accept(visitor: ArrayOperationsVisitor<R, D>, data: D): R {
        return visitor.visitMultExpression(this, data)
    }

    override fun <D> acceptChildren(visitor: ArrayOperationsVisitor<*, D>, data: D) {
        lhs.accept(visitor, data)
        operator.accept(visitor, data)
        rhs.accept(visitor, data)
    }

    override fun toString(): String {
        return "($lhs $operator $rhs)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MultExpression

        if (lhs != other.lhs) return false
        if (operator != other.operator) return false
        if (rhs != other.rhs) return false

        return true
    }

    override fun hashCode(): Int {
        var result = lhs.hashCode()
        result = 31 * result + operator.hashCode()
        result = 31 * result + rhs.hashCode()
        return result
    }

    override fun toPolynom(): Polynom {
        return lhs.toPolynom() * rhs.toPolynom()
    }
}

sealed class Operator(
    open val operator: String
) : Piece() {
    override fun <D> acceptChildren(visitor: ArrayOperationsVisitor<*, D>, data: D) {}

    override fun toString(): String {
        return operator
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Operator) return false

        if (operator != other.operator) return false

        return true
    }

    override fun hashCode(): Int {
        return operator.hashCode()
    }
}

sealed class BooleanOperator(
    override val operator: String
) : Operator(operator)

sealed class ArithmeticOperator(
    override val operator: String
) : Operator(operator)

class LessOperator(
    override val operator: String = "<"
) : BooleanOperator(operator) {
    override fun <R, D> accept(visitor: ArrayOperationsVisitor<R, D>, data: D): R {
        return visitor.visitLessOperator(this, data)
    }
}

class EqualsOperator(
    override val operator: String = "="
) : BooleanOperator(operator) {
    override fun <R, D> accept(visitor: ArrayOperationsVisitor<R, D>, data: D): R {
        return visitor.visitEqualsOperator(this, data)
    }
}

class MoreOperator(
    override val operator: String = ">"
) : BooleanOperator(operator) {
    override fun <R, D> accept(visitor: ArrayOperationsVisitor<R, D>, data: D): R {
        return visitor.visitMoreOperator(this, data)
    }
}

class OrOperator(
    override val operator: String = "|"
) : BooleanOperator(operator) {
    override fun <R, D> accept(visitor: ArrayOperationsVisitor<R, D>, data: D): R {
        return visitor.visitOrOperator(this, data)
    }
}

class AndOperator(
    override val operator: String = "&"
) : BooleanOperator(operator) {
    override fun <R, D> accept(visitor: ArrayOperationsVisitor<R, D>, data: D): R {
        return visitor.visitAndOperator(this, data)
    }
}

class PlusOperator(
    override val operator: String = "+"
) : ArithmeticOperator(operator) {
    override fun <R, D> accept(visitor: ArrayOperationsVisitor<R, D>, data: D): R {
        return visitor.visitPlusOperator(this, data)
    }
}

class MinusOperator(
    override val operator: String = "-"
) : ArithmeticOperator(operator) {
    override fun <R, D> accept(visitor: ArrayOperationsVisitor<R, D>, data: D): R {
        return visitor.visitMinusOperator(this, data)
    }
}

class MultOperator(
    override val operator: String = "*"
) : ArithmeticOperator(operator) {
    override fun <R, D> accept(visitor: ArrayOperationsVisitor<R, D>, data: D): R {
        return visitor.visitMultOperator(this, data)
    }
}