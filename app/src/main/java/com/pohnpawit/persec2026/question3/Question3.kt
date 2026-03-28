package com.pohnpawit.persec2026.question3

fun main() {
    println(
        solveQuestion3(
            "th",
            listOf("Mother", "Think", "Worthy", "Apple", "Android"),
            2
        )
    )
}

fun solveQuestion3(searchQuery: String, items: List<String>, limit: Int): List<String> {
    val query = searchQuery.lowercase().trim()

    if (query.isEmpty()) return listOf()

    return items
        .filter { it.contains(query, ignoreCase = true) }
        .sortedWith(
            compareBy(
            { it.lowercase().indexOf(query) },
            { it.lowercase() }
        ))
        .take(limit)
}
