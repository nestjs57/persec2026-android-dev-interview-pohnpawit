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
        "{",
    )

    inputs.forEach { input ->
        println("$input => ${solveQuestion1(input)}")
    }
}

fun solveQuestion1(input: String): Boolean {
    val brackets = listOf("()", "[]", "{}")
    val validChars = listOf('(', ')', '[', ']', '{', '}')

    var inputTrim = input.trim()

    when {
        inputTrim.isEmpty() -> return false
        inputTrim.isBlank() -> return false
        inputTrim.length.mod(2) != 0 -> return false
        inputTrim.any { it !in validChars } -> return false
    }

    while (brackets.any { inputTrim.contains(it) }) {
        brackets.forEach {
            inputTrim = inputTrim.replace(it, "")
        }
    }

    return inputTrim.isBlank()
}
