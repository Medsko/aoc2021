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
    internal fun coordinateRange() {
        val expected = listOf(Coordinate(1, 4), Coordinate(2, 4), Coordinate(3, 4))
        val range = Coordinate(3, 4)..Coordinate(1, 4)
        assertEquals(expected, range.toCollection(ArrayList()))
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
