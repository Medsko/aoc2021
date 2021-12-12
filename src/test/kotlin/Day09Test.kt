import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day09Test {

    private val tubular = Day09()

    @Test
    internal fun part1TestRun() {
        val input = listOf("2199943210", "3987894921", "9856789892", "8767896789", "9899965678")
            .map { it.toCharArray().map { digit -> Character.getNumericValue(digit) } }
        val lowPoints = tubular.determineLowPointsByPositions(input)
        assertEquals(listOf(1, 0, 5, 5), lowPoints)

        val total = tubular.part1(input)
        assertEquals(15, total)
    }

    @Test
    internal fun part1ForReal() {
        val input = getRealInputAsIntsForDay(9)
        val total = tubular.part1(input)
        assertEquals(566, total)
    }

    @Test
    internal fun determineLowPointsByPositions() {
        val input = listOf("2199943210", "3987894921", "9856789892", "8767896789", "9899965678")
            .map { it.toCharArray().map { digit -> Character.getNumericValue(digit) } }
        val lowPoints = tubular.determineLowPointsByPositions(input)
        assertEquals(listOf(1, 0, 5, 5), lowPoints)
    }

    @Test
    internal fun determineAdjacentHighPoints() {
        val input = listOf("2199943210", "3987894921", "9856789892", "8767896789", "9899965678")
            .map { it.toCharArray().map { digit -> Character.getNumericValue(digit) } }
        val lowPoints = tubular.determineLowPositions(input)
        val basin = mutableSetOf<Pair<Int, Int>>()
        tubular.determineAdjacentHighPoints(lowPoints[0], input, basin)
        assertEquals(setOf(Pair(1,0), Pair(0,0), Pair(0,1)), basin)
    }

    @Test
    internal fun part2TestRun() {
        val input = listOf("2199943210", "3987894921", "9856789892", "8767896789", "9899965678")
            .map { it.toCharArray().map { digit -> Character.getNumericValue(digit) } }
        assertEquals(1134, tubular.part2(input))
    }

    @Test
    internal fun part2ForReal() {
        val input = getRealInputAsIntsForDay(9)
        assertEquals(891684, tubular.part2(input))
    }

}