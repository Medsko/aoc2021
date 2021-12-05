import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.fail
import org.junit.jupiter.api.Test

internal class Day05Test {

    private val hydrothermalVenter = Day05()

    @Test
    internal fun part1TestRun() {
        val coordinatePairs = hydrothermalVenter.parseInput(getTestInput())
        val occurrences = coordinatePairs.filter { it.first.isHorizontalOrVertical(it.second) }
            .flatMap { it.first..it.second }.count { it == Coordinate(0, 9) }
        assertEquals(2, occurrences)
        assertEquals(5, hydrothermalVenter.part1(getTestInput()))
    }

    @Test
    internal fun part1ForReal() {
        assertEquals(5306, hydrothermalVenter.part1(getRealInput()))
    }

    @Test
    internal fun part2TestRun() {
        val coordinatePairs = hydrothermalVenter.parseInput(getTestInput())
        val occurrences = coordinatePairs
            .flatMap { it.first..it.second }.count { it == Coordinate(4, 4) }
        assertEquals(3, occurrences)
        assertEquals(12, hydrothermalVenter.part2(getTestInput()))
    }

    @Test
    internal fun part2ForReal() {
        assertEquals(17787, hydrothermalVenter.part2(getRealInput()))
    }

    @Test
    internal fun coordinateRange() {
        val expected = listOf(Coordinate(1, 4), Coordinate(2, 4), Coordinate(3, 4))
        val range = Coordinate(3, 4)..Coordinate(1, 4)
        assertEquals(expected, range.toCollection(ArrayList()))
    }

    @Test
    internal fun coordinateRangeDiagonalParallel() {
        val expected = listOf(Coordinate(1, 1), Coordinate(2, 2), Coordinate(3, 3))
        val range = Coordinate(1, 1)..Coordinate(3, 3)
        assertEquals(expected, range.toCollection(ArrayList()))
    }

    @Test
    internal fun coordinateRangeDiagonal() {
        val expected = listOf(Coordinate(9, 7), Coordinate(8, 8), Coordinate(7, 9))
        val range = Coordinate(9, 7)..Coordinate(7, 9)
        val rangeAsList = range.toCollection(ArrayList())
        rangeAsList.reverse()
        assertEquals(expected, rangeAsList)
    }

    @Test
    internal fun parseInput() {
        val parsed = hydrothermalVenter.parseInput(getTestInput())
        assertEquals(Pair(Coordinate(0, 9), Coordinate(5, 9)), parsed[0])
    }

    private fun getTestInput(): List<String> {
        return Day01::class.java.classLoader.getResource("example/day05.txt")?.readText()?.lines() ?: fail()
    }

    private fun getRealInput(): List<String> {
        return Day01::class.java.classLoader.getResource("day05.txt")?.readText()?.lines() ?: fail()
    }
}
