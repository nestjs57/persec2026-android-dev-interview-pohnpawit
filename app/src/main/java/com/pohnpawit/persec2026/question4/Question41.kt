package com.pohnpawit.persec2026.question4


fun main() {
    val numberInputs = listOf(1989, 2000, 68, 109, 2421)
    numberInputs.forEach { input ->
        println("$input => ${numberToRoman(input)}")
    }
}

fun numberToRoman(number: Int): String {
    val valueToRomanLabel = mapOf(
        1000 to "M",
        900 to "CM",
        500 to "D",
        400 to "CD",
        100 to "C",
        90 to "XC",
        50 to "L",
        40 to "XL",
        10 to "X",
        9 to "IX",
        5 to "V",
        4 to "IV",
        1 to "I"
    )

    require(number > 0) { "roman numerals start from 1 (no zero/negative values)" }
    require(number <= 3999) { "standard form limit is 3999 (rule of three for M)" }

    var remainingValue = number
    var romanSymbol = ""

    for ((value, symbol) in valueToRomanLabel) {
        if (remainingValue == 0) break

        val symbolCount = remainingValue.div(value)
        repeat(symbolCount) {
            romanSymbol = romanSymbol.plus(symbol)
        }
        remainingValue = remainingValue.mod(value)
    }

    return romanSymbol
}
