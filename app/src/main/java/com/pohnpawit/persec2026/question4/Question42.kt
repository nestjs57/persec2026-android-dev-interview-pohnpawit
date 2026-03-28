package com.pohnpawit.persec2026.question4


fun main() {
    val romanInputs = listOf(
        "MCMLXXXIX",
        "MM",
        "LXVIII",
        "IX",
    )
    romanInputs.forEach { input ->
        println("$input => ${romanToNumber(input)}")
    }
}

fun romanToNumber(roman: String): Int {
    val symbolValues =
        mapOf(
            'M' to 1000,
            'D' to 500,
            'C' to 100,
            'L' to 50,
            'X' to 10,
            'V' to 5,
            'I' to 1
        )

    val input = roman.uppercase().trim()
    if (input.isEmpty()) throw IllegalArgumentException("roman must not be empty")

    var totalValueOfRoman = 0
    var previousValue = 0
    var previousChar: Char? = null
    var repeatCount = 0

    for (i in input.length - 1 downTo 0) {
        val currentChar = input[i]
        val currentValue = symbolValues[currentChar]
            ?: throw IllegalArgumentException("invalid symbol: $currentChar")

        repeatCount = if (currentChar == previousChar)
            repeatCount + 1
        else 1
        validateMaxRepetition(currentChar, repeatCount)

        if (currentValue < previousValue) {
            validateAllowedNextChars(currentChar, previousChar)
            totalValueOfRoman -= currentValue
        } else {
            totalValueOfRoman += currentValue
        }

        previousValue = currentValue
        previousChar = currentChar
    }
    return totalValueOfRoman
}

private fun validateMaxRepetition(char: Char, count: Int) {
    val limitFor = mapOf(
        'I' to 3,
        'X' to 3,
        'C' to 3,
        'M' to 3,
        'V' to 1,
        'L' to 1,
        'D' to 1
    )

    val limit = limitFor[char] ?: 1
    if (count > limit) {
        throw IllegalArgumentException("too many $char: max is $limit")
    }
}

private fun validateAllowedNextChars(current: Char, next: Char?) {
    val canBePlacedBefore =
        mapOf(
            'I' to setOf('V', 'X'),
            'X' to setOf('L', 'C'),
            'C' to setOf('D', 'M')
        )

    val allowedNextChars = canBePlacedBefore[current]
    if (allowedNextChars == null || next !in allowedNextChars) {
        throw IllegalArgumentException("invalid sequence: $current is not allowed before $next")
    }
}
