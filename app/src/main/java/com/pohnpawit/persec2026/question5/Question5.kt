package com.pohnpawit.persec2026.question5

fun main() {
    val numberInputs = listOf(3008, 1989, 2679, 9163)
    numberInputs.forEach { input ->
        println("$input => ${solveQuestion5(input)}")
    }
}

fun solveQuestion5(input: Int): Int {
    require(input > 0) { "input must be positive integer" }

    val result = input.toString()
        .toList()
        .sortedDescending()
        .joinToString("")
        .toInt()

    require(result <= Int.MAX_VALUE) { "result exceeds int range: $result" }
    return result.toInt()
}
