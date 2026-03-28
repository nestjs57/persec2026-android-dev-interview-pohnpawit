package com.pohnpawit.persec2026

import com.pohnpawit.persec2026.question4.numberToRoman
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class Question41Test {

    @Test
    fun should_return_correct_roman_for_standard_numbers() {
        assertEquals("MCMLXXXIX", numberToRoman(1989))
        assertEquals("MM", numberToRoman(2000))
        assertEquals("LXVIII", numberToRoman(68))
        assertEquals("CIX", numberToRoman(109))
    }

    @Test
    fun should_return_correct_roman_for_min_and_max() {
        assertEquals("I", numberToRoman(1))
        assertEquals("MMMCMXCIX", numberToRoman(3999))
    }

    @Test
    fun should_throw_when_number_is_zero() {
        assertThrows(IllegalArgumentException::class.java) {
            numberToRoman(0)
        }
    }

    @Test
    fun should_throw_when_number_is_negative() {
        assertThrows(IllegalArgumentException::class.java) {
            numberToRoman(-1)
        }
    }

    @Test
    fun should_throw_when_number_exceeds_3999() {
        assertThrows(IllegalArgumentException::class.java) {
            numberToRoman(4000)
        }
    }
}
