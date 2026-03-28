package com.pohnpawit.persec2026

import com.pohnpawit.persec2026.question2.solveQuestion2
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class Question2Test {

    @Test
    fun should_sort_by_prefix_number_and_suffix() {
        val input = listOf("TH19", "SG20", "TH2")
        val expected = listOf("SG20", "TH2", "TH19")
        assertEquals(expected, solveQuestion2(input))
    }

    @Test
    fun should_sort_by_number() {
        val input = listOf("A10", "A2", "A1")
        val expected = listOf("A1", "A2", "A10")
        assertEquals(expected, solveQuestion2(input))
    }

    @Test
    fun should_sort_by_suffix() {
        val input = listOf("A10C", "A10A", "A10B")
        val expected = listOf("A10A", "A10B", "A10C")
        assertEquals(expected, solveQuestion2(input))
    }

    @Test
    fun should_sort_uppercase_before_lowercase() {
        val input = listOf("b1", "A1", "a1")
        val expected = listOf("A1", "a1", "b1")
        assertEquals(expected, solveQuestion2(input))
    }

    @Test
    fun should_support_very_large_numbers() {
        val largeNum = "TH9000000000000000000"
        val input = listOf(largeNum, "TH2")
        val expected = listOf("TH2", largeNum)
        assertEquals(expected, solveQuestion2(input))
    }

    @Test
    fun should_return_empty_list_when_input_is_empty() {
        assertEquals(listOf<String>(), solveQuestion2(listOf()))
    }

    @Test
    fun should_throw_error_on_invalid_format() {
        assertThrows(IllegalArgumentException::class.java) {
            solveQuestion2(listOf("INVALID_DATA"))
        }
    }

    @Test
    fun should_throw_error_when_number_is_too_long() {
        val tooLongNum = "TH99999999999999999999"
        assertThrows(IllegalArgumentException::class.java) {
            solveQuestion2(listOf(tooLongNum))
        }
    }
}
