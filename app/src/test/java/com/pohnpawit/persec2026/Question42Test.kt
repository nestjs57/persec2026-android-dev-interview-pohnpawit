package com.pohnpawit.persec2026

import com.pohnpawit.persec2026.question4.romanToNumber
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class Question42Test {

    @Test
    fun should_return_correct_number_for_standard_roman() {
        assertEquals(1989, romanToNumber("MCMLXXXIX"))
        assertEquals(2000, romanToNumber("MM"))
        assertEquals(68, romanToNumber("LXVIII"))
        assertEquals(9, romanToNumber("IX"))
    }

    @Test
    fun should_return_correct_number_for_min_and_max() {
        assertEquals(1, romanToNumber("I"))
        assertEquals(3999, romanToNumber("MMMCMXCIX"))
    }

    @Test
    fun should_ignore_case() {
        assertEquals(1989, romanToNumber("mcmlxxxix"))
        assertEquals(2000, romanToNumber("mm"))
    }

    @Test
    fun should_throw_when_input_is_empty() {
        assertThrows(IllegalArgumentException::class.java) {
            romanToNumber("")
        }
    }

    @Test
    fun should_throw_when_invalid_symbol() {
        assertThrows(IllegalArgumentException::class.java) {
            romanToNumber("ABC")
        }
    }

    @Test
    fun should_throw_when_repeated_more_than_3_times() {
        assertThrows(IllegalArgumentException::class.java) {
            romanToNumber("IIII")
        }
    }

    @Test
    fun should_throw_when_invalid_order() {
        assertThrows(IllegalArgumentException::class.java) {
            romanToNumber("IC")
        }
    }

    @Test
    fun should_throw_when_non_repeatable_symbol_is_repeated() {
        assertThrows(IllegalArgumentException::class.java) {
            romanToNumber("VV")
        }
    }
}
