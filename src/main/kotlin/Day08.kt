class Day08 {

    private val mappings = mapOf(
        "abcefg" to "0",
        "cf" to "1",
        "acdeg" to "2",
        "acdfg" to "3",
        "bcdf" to "4",
        "abdfg" to "5",
        "abdefg" to "6",
        "acf" to "7",
        "abcdefg" to "8",
        "abcdfg" to "9"
    )

    fun part1(combinations: List<List<String>>): Int {
        return combinations.flatten().map { it.length }.count { it in listOf(2, 3, 4, 7) }
    }

    fun part2(input: List<Pair<List<String>, List<String>>>): Int {
        return input.sumOf { calculateOutputValue(it) }
    }

    private fun calculateOutputValue(input: Pair<List<String>, List<String>>): Int {
        val combinationsToValues = mapCombinationToValue(input.first)
        val alphabeticallySortedValues = input.second.map { it.toCharArray().sorted().joinToString("") }
        val outputValue = alphabeticallySortedValues.joinToString("") { combinationsToValues[it]!! }
        return outputValue.toInt()
    }

    fun mapCombinationToValue(combinations: List<String>): Map<String, String> {
        val one = combinations.find { it.length == 2 }!!
        val four = combinations.find { it.length == 4 }!!
        val occurrences = determineOccurrences(combinations)
        val segmentTranslations = translateSegments(occurrences, one, four)
        val alphabeticallySortedCombinations = combinations.map { it.toCharArray().sorted().joinToString("") }
        return alphabeticallySortedCombinations.associateWith { mappings[translateCombination(it, segmentTranslations)]!! }
    }

    private fun translateCombination(combination: String, segmentTranslations: MutableMap<Char, Char>): String {
        return combination.toCharArray().map { segmentTranslations[it]!! }.sorted().joinToString("")
    }

    private fun translateSegments(segmentsWithOccurrences: Map<Char, Int>, oneCode: String, fourCode: String): MutableMap<Char, Char> {
        val translated = mutableMapOf<Char, Char>()

        for (entry in segmentsWithOccurrences) {
            val translation = if (entry.value == 4) 'e'
            else if (entry.value == 6) 'b'
            else if (entry.value == 9) 'f'
            else if (entry.value == 8) if (oneCode.contains(entry.key)) 'c' else 'a'
            else if (entry.value == 7) if (fourCode.contains(entry.key)) 'd' else 'g'
            else 'q'
            translated[entry.key] = translation
        }
        return translated
    }

    private fun determineOccurrences(combinations: List<String>): Map<Char, Int> {
        return combinations.flatMap { it.toCharArray().asIterable() }.groupingBy { it }.eachCount()
    }

    fun parseInput(lines: List<String>): List<Pair<List<String>, List<String>>> {
        return lines.map { it.split("|") }
            .map { Pair(it[0].trim().split(" "), it[1].trim().split(" ")) }
    }

}