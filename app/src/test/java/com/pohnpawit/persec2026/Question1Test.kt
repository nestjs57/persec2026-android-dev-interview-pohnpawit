package com.pohnpawit.persec2026

import com.pohnpawit.persec2026.question1.solveQuestion1
import org.junit.Assert.assertEquals
import org.junit.Test

class Question1Test {

    @Test
    fun should_return_true_when_brackets_are_valid() {
        assertEquals(true, solveQuestion1("()"))
        assertEquals(true, solveQuestion1("() "))
        assertEquals(true, solveQuestion1("([{}])"))
    }

    @Test
    fun should_return_false_when_brackets_are_invalid() {
        assertEquals(false, solveQuestion1("([]]"))
        assertEquals(false, solveQuestion1("([[{}]]]"))
        assertEquals(false, solveQuestion1(")"))
        assertEquals(false, solveQuestion1("(]}])"))
        assertEquals(false, solveQuestion1("([)]"))
        assertEquals(false, solveQuestion1("{"))
    }

    @Test
    fun should_return_false_when_input_is_blank() {
        assertEquals(false, solveQuestion1(""))
    }

    @Test
    fun should_return_false_when_input_is_empty() {
        assertEquals(false, solveQuestion1(""))
    }

    @Test
    fun should_return_false_when_input_contains_invalid_characters() {
        assertEquals(false, solveQuestion1("asd"))
    }

    @Test
    fun should_return_false_when_input_length_is_odd() {
        assertEquals(false, solveQuestion1(")"))
    }
}
