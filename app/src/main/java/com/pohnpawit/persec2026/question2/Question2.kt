package com.pohnpawit.persec2026.question2

fun main() {
    val inputs = listOf(
        listOf("TH19", "SG20", "TH2"),
        listOf("TH10", "TH3Netflix", "TH1", "TH7")
    )
    inputs.forEach { input ->
        println("$input => ${solveQuestion2(input)}")
    }
}

fun solveQuestion2(inputs: List<String>): List<String> {
    val results = inputs.map { input ->
        val regex = Regex("^([a-zA-Z]+)(\\d+)([a-zA-Z]*)$")
        val match = regex.find(input)
            ?: throw IllegalArgumentException("invalid format: $input")

        val prefix = match.groupValues[1]
        val numberStr = match.groupValues[2]
        val suffix = match.groupValues[3]

        val number =
            numberStr.toLongOrNull() ?: throw IllegalArgumentException()

        Triple(prefix, number, suffix)
    }.sortedWith(
        compareBy(
            { it.first },
            { it.second },
            { it.third })
    ).map { "${it.first}${it.second}${it.third}" }
    return results
}
