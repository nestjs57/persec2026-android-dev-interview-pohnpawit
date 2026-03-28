package com.pohnpawit.persec2026

import com.pohnpawit.persec2026.question3.solveQuestion3
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class Question3Test {

    @Test
    fun should_sort_by_match_position() {
        val items = listOf("Mother", "Think", "Worthy")
        val result = solveQuestion3("th", items, 2)
        assertEquals(listOf("Think", "Mother"), result)
    }

    @Test
    fun should_sort_by_A_to_Z_when_index_matches() {
        val items = listOf("Think", "Thatch")
        val result = solveQuestion3("Th", items, 2)
        assertEquals(listOf("Thatch", "Think"), result)
    }

    @Test
    fun should_ignore_case() {
        val result = solveQuestion3("TH", listOf("Think"), 1)
        assertEquals(listOf("Think"), result)
    }

    @Test
    fun should_limit_results() {
        val items = listOf("Apple", "Android", "Ant")
        val result = solveQuestion3("A", items, 2)
        assertEquals(2, result.size)
    }

    @Test
    fun should_return_empty_when_not_found() {
        val result = solveQuestion3("xyz", listOf("Apple"), 5)
        assertTrue(result.isEmpty())
    }

    @Test
    fun should_handle_empty_inputs() {
        assertTrue(solveQuestion3("th", listOf(), 5).isEmpty())
        assertTrue(solveQuestion3("", listOf("Think"), 5).isEmpty())
        assertTrue(solveQuestion3("th", listOf("Think"), 0).isEmpty())
    }
}
