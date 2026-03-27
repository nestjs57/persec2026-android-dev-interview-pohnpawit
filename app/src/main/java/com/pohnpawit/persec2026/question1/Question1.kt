package com.pohnpawit.persec2026.question1

fun main() {
    val inputs = listOf(
        "()",
        "([]]",
        "([{}])",
        "([[{}]]]",
        ")",
        "(]}])",
        "([)]",
        "{"
    )

    inputs.forEach { input ->
        println("$input => ${solveQuestion1(input)}")
    }
}

fun solveQuestion1(input: String): Boolean {
    val brackets = listOf("()", "[]", "{}")
    val validChars = listOf('(', ')', '[', ']', '{', '}')

    when {
        input.isEmpty() -> return false
        input.isBlank() -> return false
        input.length.mod(2) != 0 -> return false
        input.any { it !in validChars } -> return false
    }

    var inputTrim = input.trim()

    while (brackets.any { inputTrim.contains(it) }) {
        brackets.forEach {
            inputTrim = inputTrim.replace(it, "")
        }
    }

    return inputTrim.isBlank()
}
