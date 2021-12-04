class Day03 {

    fun part1(report: List<String>): Int {
        val gamma = determineMostCommon(report)
        val epsilon = flipBits(gamma)
        return Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2)
    }

    fun part2(report: List<String>): Int {
        val ogygenGeneratorRating = determineAndKeep(report, true)[0]
        val co2ScrubberRating = determineAndKeep(report, false)[0]
        return Integer.parseInt(ogygenGeneratorRating, 2) * Integer.parseInt(co2ScrubberRating, 2)
    }

    fun determineAndKeep(report: List<String>, findMostCommon: Boolean): List<String> {
        var keep = report
        var index = 0
        while (keep.size != 1) {
            val (ones, zeroes) = splitByBitAt(keep, index)
            keep = determineWhichToKeep(ones, zeroes, findMostCommon)
            index++
        }
        return keep
    }

    private fun determineWhichToKeep(ones: List<String>, zeroes: List<String>, findMostCommon: Boolean): List<String> {
        if (ones.size == zeroes.size) {
            return if (findMostCommon) ones else zeroes
        }
        if (findMostCommon) {
            return if (ones.size > zeroes.size) ones else zeroes
        }
        return if (ones.size < zeroes.size) ones else zeroes
    }

    private fun splitByBitAt(report: List<String>, index: Int): Pair<List<String>,List<String>> {
        val ones = report.filter { it[index] == '1' }
        val zeroes = report.filter { it[index] == '0' }
        return Pair(ones, zeroes)
    }

    private fun determineMostCommon(report: List<String>): String {
        val result = MutableList(report[0].length) { 0 }
        report.forEach {
            it.forEachIndexed { i, char -> if (char == '1') result[i]++ }
        }
        return result.joinToString("") { if (it > report.size / 2) "1" else "0" }
    }

    private fun flipBits(bits: String): String {
        return bits.replace("1", "2").replace("0", "1").replace("2", "0")
    }
}