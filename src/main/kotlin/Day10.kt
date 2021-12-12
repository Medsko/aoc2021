class Day10 {

    private val closingTokens = mapOf(
        ')' to '(',
        ']' to '[',
        '}' to '{',
        '>' to '<'
    )

    private val closingTokenScores = mapOf(
        ')' to 3,
        ']' to 57,
        '}' to 1197,
        '>' to 25137
    )

    private val unclosedTokenScores = mapOf(
        '(' to 1L,
        '[' to 2L,
        '{' to 3L,
        '<' to 4L
    )

    fun part1(lines: List<String>): Int {
        return lines.map { validate(it) }.filter { it != 0 }.reduce { acc, i -> acc + i }
    }

    fun part2(lines: List<String>): Long {
        val autocompleteScores = lines.map { findUnclosedTokens(it) }.filter { it.isNotEmpty() }
            .map { calculateAutocompleteScore(it) }.sorted()
        return autocompleteScores[autocompleteScores.size / 2]
    }

    private fun calculateAutocompleteScore(unclosedTokens: List<Char>): Long {
        return unclosedTokens.reversed().map { unclosedTokenScores[it]!! }.reduce { acc, score -> (acc * 5) + score }
    }

    fun findUnclosedTokens(line: String): List<Char> {
        val stack = ArrayDeque<Char>()

        for (token in line.toCharArray()) {
            if (closingTokens.containsKey(token)) {
                val previous = stack.removeLastOrNull()
                if (previous != null && closingTokens[token]!! == previous) continue
                else return ArrayList()
            } else {
                stack.addLast(token)
            }
        }

        return stack
    }

    fun validate(line: String): Int {
        val stack = ArrayDeque<Char>()

        for (token in line.toCharArray()) {
            if (closingTokens.containsKey(token)) {
                val previous = stack.removeLastOrNull()
                if (previous != null && closingTokens[token]!! == previous) continue
                else return closingTokenScores[token]!!
            } else {
                stack.addLast(token)
            }
        }

        return 0
    }
}