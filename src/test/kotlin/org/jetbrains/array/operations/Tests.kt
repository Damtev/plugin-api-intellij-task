package org.jetbrains.array.operations

import ArrayOperationsChainToTreeTransformer
import ArrayOperationsChainToTreeTransformer.InvalidSyntaxException
import ArrayOperationsChainToTreeTransformer.InvalidTypeException
import MAX_NUMBER
import MIN_NUMBER
import apply
import generateChain
import org.jetbrains.array.operations.tree.Chain
import org.junit.Assert
import org.junit.Test
import simplify
import transform
import java.util.*
import kotlin.random.Random

const val MIN_LIST_LEN = 1
const val MAX_LIST_LEN = 100
const val CHAINS_AMOUNT = 100
const val LISTS_AMOUNT = 100

class Tests {

    @Test
    fun debugTests() {
        println("DEBUG TESTS:")
        val transformer = ArrayOperationsChainToTreeTransformer()
        val dir = "testData/"
        val tests = Array(6) {i -> "failedTest${i + 1}"}
        tests.forEach {
            try {
                val chain = transformer.transform(dir + it)
                chain.test()
            } catch (e: Exception) {
                when (e) {
                    is InvalidTypeException, is InvalidSyntaxException -> println(e.message)
                }
            }
        }
        println("=".repeat(40))
    }

    @Test
    fun randomTests() {
        println("RANDOM TESTS:")
        repeat(CHAINS_AMOUNT) {
            val chain = generateChain()
            chain.test()
        }
        println("=".repeat(40))
    }

    @Test
    fun doSampleTests() {
        println("SAMPLE TESTS:")
        val transformer = ArrayOperationsChainToTreeTransformer()
        val dir = "testData/"
        val tests = arrayListOf("test1", "test2", "test3", "test4")
        tests.forEach {
            try {
                val chain = transformer.transform(dir + it)
                chain.test()
            } catch (e: Exception) {
                when (e) {
                    is InvalidTypeException, is InvalidSyntaxException -> println(e.message)
                }
            }
        }
        println("=".repeat(40))
    }

    @Test
    fun doInvalidTests() {
        println("INVALID TESTS:")
        val transformer = ArrayOperationsChainToTreeTransformer()
        val dir = "testData/"
        val tests = arrayListOf("invalidSyntaxTest1", "invalidTypesTest1")
        tests.forEach {
            try {
                val chain = transformer.transform(dir + it)
                chain.test()
            } catch (e: Exception) {
                when (e) {
                    is InvalidTypeException, is InvalidSyntaxException -> println(e.message)
                }
            }
        }
        println("=".repeat(40))
    }

    private fun generateNumbers(): List<Int> {
        val time = Calendar.getInstance().timeInMillis
        val len = Random(time).nextInt(MIN_LIST_LEN, MAX_LIST_LEN + 1)
        return List(len) {
            Random.nextInt(MIN_NUMBER, MAX_NUMBER + 1)
        }
    }

    private fun Chain.test() {
        val transformed = this.transform().simplify()
        repeat(LISTS_AMOUNT) {
            val numbers = generateNumbers()
            val originalApplied = numbers.apply(this)
            val tranformedApplied = numbers.apply(transformed)
            val message = """
                    Original numbers:  $numbers
                    Original chain:    $this
                    Transformed chain: $transformed
                    Expected numbers:  $originalApplied
                    Actual numbers:    $tranformedApplied
                """.trimIndent()
            Assert.assertArrayEquals(
                """
                ERROR:
                    $message
            """.trimIndent(), originalApplied.toIntArray(), tranformedApplied.toIntArray()
            )
        }
        println(this)
        println(transformed)
        println("-".repeat(40))
    }
}