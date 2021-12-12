import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day09Test {

    private val tubular = Day09()

    @Test
    internal fun part1TestRun() {
        val input = listOf("2199943210", "3987894921", "9856789892", "8767896789", "9899965678")
        val lowPoints = tubular.determineLowPoints(input)
        assertEquals(listOf(1, 0, 5, 5), lowPoints)

        val total = tubular.part1(input)
        assertEquals(15, total)
    }

    @Test
    internal fun part1ForReal() {
        val input = getRealInputForDay(9)
        val total = tubular.part1(input)
        assertEquals(566, total)
    }

}