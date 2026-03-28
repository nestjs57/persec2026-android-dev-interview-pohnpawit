package com.pohnpawit.persec2026

import com.pohnpawit.persec2026.question1.solveQuestion1
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class Question1Test {

    @Test
    fun should_return_true_for_basic_brackets() {
        assertTrue(solveQuestion1("()"))
        assertTrue(solveQuestion1("[]"))
        assertTrue(solveQuestion1("{}"))
    }

    @Test
    fun should_return_true_for_nested_brackets() {
        assertTrue(solveQuestion1("([{}])"))
        assertTrue(solveQuestion1("{[()]}"))
    }

    @Test
    fun should_return_false_for_wrong_order() {
        assertFalse(solveQuestion1("([)]"))
        assertFalse(solveQuestion1(")("))
        assertFalse(solveQuestion1("([}{])"))
    }

    @Test
    fun should_return_false_for_mismatched_types() {
        assertFalse(solveQuestion1("([]]"))
        assertFalse(solveQuestion1("(]}])"))
    }

    @Test
    fun should_return_false_for_odd_length() {
        assertFalse(solveQuestion1("{"))
        assertFalse(solveQuestion1("((("))
        assertFalse(solveQuestion1("())"))
    }

    @Test
    fun should_return_false_for_unbalanced_same_type() {
        assertFalse(solveQuestion1("(("))
        assertFalse(solveQuestion1("())( "))
    }

    @Test
    fun should_return_false_for_empty_or_blank_input() {
        assertFalse(solveQuestion1(""))
        assertFalse(solveQuestion1("   "))
    }

    @Test
    fun should_return_false_for_invalid_characters() {
        assertFalse(solveQuestion1("(a)"))
        assertFalse(solveQuestion1("asd"))
    }
}
