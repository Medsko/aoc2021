class Day04 {

    fun part1(input: List<String>): Int {
        val (drawnNumbers, bingoCards) = parseInput(input)
        return findWinningScore(drawnNumbers, bingoCards)
    }

    fun part2(input: List<String>): Int {
        val (drawnNumbers, bingoCards) = parseInput(input)
        return findLosingScore(drawnNumbers, bingoCards)
    }

    private fun findWinningScore(drawnNumbers: List<Int>, bingoCards: List<BingoCard>): Int {
        for (i in drawnNumbers) {
            val winningCard = bingoCards.onEach { it.crossOut(i) }.find { it.bingo() }
            if (winningCard != null) {
                return winningCard.remainder() * i
            }
        }
        throw IllegalStateException("No bingo!")
    }

    private fun findLosingScore(drawnNumbers: List<Int>, bingoCards: List<BingoCard>): Int {
        val cardsStillInTheGame = bingoCards.toMutableList()
        for (i in drawnNumbers) {
            val winningCards = cardsStillInTheGame.onEach { it.crossOut(i) }.filter { it.bingo() }
            cardsStillInTheGame.removeAll(winningCards)
            if (cardsStillInTheGame.isEmpty()) return winningCards[0].remainder() * i
        }
        throw IllegalStateException("No bingo!")
    }

    fun parseInput(input: List<String>): Pair<List<Int>, List<BingoCard>> {
        val drawnNumbers = input[0].trim().split(",".toRegex()).map { Integer.parseInt(it) }
        val bingoCards = input.subList(2, input.size).filter { it.isNotEmpty() }.chunked(5).map { BingoCard(it) }
        return Pair(drawnNumbers, bingoCards)
    }
}

class BingoCard (lines: List<String>) {
    private val combinations: MutableList<MutableList<Int>> = mutableListOf()
    init {
        if (lines.size != 5) throw IllegalArgumentException("Incorrect number of lines: ${lines.size}; should be 5.")
        for (i in 0..4) {
            val newCombination = lines.map { it.trim().split("\\s+".toRegex()) }.map { Integer.parseInt(it[i]) }.toCollection(mutableListOf())
            combinations.add(newCombination)
        }
        lines.map { line -> line.trim().split(Regex("\\s+")).map { Integer.parseInt(it) } }
            .forEach { combinations.add(it.toMutableList()) }
    }

    fun crossOut(number: Int) {
        combinations.forEach { it.remove(number) }
    }

    fun bingo(): Boolean {
        return combinations.any { it.isEmpty() }
    }

    fun remainder(): Int {
        // Divide by two, because each value is present in two combinations (vertical and horizontal)
        return combinations.flatten().sum() / 2
    }

}