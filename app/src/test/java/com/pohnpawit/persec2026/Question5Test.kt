package com.pohnpawit.persec2026

import com.pohnpawit.persec2026.question5.solveQuestion5
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test


class Question5Test {

    @Test
    fun should_return_sorted_digits_descending() {
        assertEquals(8300, solveQuestion5(3008))
        assertEquals(9981, solveQuestion5(1989))
        assertEquals(9762, solveQuestion5(2679))
        assertEquals(9631, solveQuestion5(9163))
    }

    @Test
    fun should_return_same_when_single_digit() {
        assertEquals(5, solveQuestion5(5))
    }

    @Test
    fun should_return_same_when_all_digits_are_equal() {
        assertEquals(1111, solveQuestion5(1111))
    }

    @Test
    fun should_handle_trailing_zeros() {
        assertEquals(8300, solveQuestion5(3008))
    }

    @Test
    fun should_throw_when_input_is_zero() {
        assertThrows(IllegalArgumentException::class.java) {
            solveQuestion5(0)
        }
    }

    @Test
    fun should_throw_when_input_is_negative() {
        assertThrows(IllegalArgumentException::class.java) {
            solveQuestion5(-1)
        }
    }

    @Test
    fun should_throw_when_result_exceeds_max_integer() {
        assertThrows(IllegalArgumentException::class.java) {
            solveQuestion5(1147483647)
        }
    }
}
