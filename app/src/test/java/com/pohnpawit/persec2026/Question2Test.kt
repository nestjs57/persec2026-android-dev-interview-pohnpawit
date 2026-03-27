package com.pohnpawit.persec2026

import com.pohnpawit.persec2026.question2.solveQuestion2
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class Question2Test {

    @Test
    fun should_return_sorted_by_prefix_then_number_then_suffix() {
        assertEquals(listOf("SG20", "TH2", "TH19"), solveQuestion2(listOf("TH19", "SG20", "TH2")))
    }

    @Test
    fun should_return_sorted_with_suffix() {
        assertEquals(
            listOf("TH1", "TH3Netflix", "TH7", "TH10"),
            solveQuestion2(listOf("TH10", "TH3Netflix", "TH1", "TH7"))
        )
    }

    @Test
    fun should_throw_when_invalid_format() {
        assertThrows(IllegalArgumentException::class.java) {
            solveQuestion2(listOf("TH19", "INVALID"))
        }
    }

    @Test
    fun should_return_empty_list_when_input_is_empty() {
        assertEquals(listOf<String>(), solveQuestion2(listOf()))
    }
}
