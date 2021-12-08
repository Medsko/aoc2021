import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.fail
import org.junit.jupiter.api.Test

internal class Day07Test {

    private val crabFisher = Day07()

    @Test
    internal fun part1TestRun() {
        val positionWithLeastFuel = crabFisher.part1(getTestInput())
        assertEquals(2, positionWithLeastFuel)
        assertEquals(37, crabFisher.calculateTotalDistance(2, getTestInput()))
    }

    @Test
    internal fun part1ForReal() {
        val positionWithLeastFuel = crabFisher.part1(getRealInput())
        assertEquals(311, positionWithLeastFuel)
        assertEquals(347011, crabFisher.calculateTotalDistance(positionWithLeastFuel, getRealInput()))
    }

    @Test
    internal fun triangularMap() {
        val triangularMap = crabFisher.getTriangularMap(getTestInput())
        assertEquals(66, triangularMap[11])
    }

    @Test
    internal fun calculateTriangularDistance() {
        val triangularMap = crabFisher.getTriangularMap(getTestInput())
        assertEquals(206, crabFisher.calculateTotalTriangularDistance(2, getTestInput(), triangularMap))
        assertEquals(168, crabFisher.calculateTotalTriangularDistance(5, getTestInput(), triangularMap))
    }

    @Test
    internal fun part2TestRun() {
        assertEquals(168, crabFisher.part2(getTestInput()))
    }

    @Test
    internal fun part2ForReal() {
        assertEquals(98363777, crabFisher.part2(getRealInput()))
    }

    private fun getTestInput(): List<Int> {
        return "16,1,2,0,4,2,7,1,2,14".split(",").map { it.toInt() }
    }

    private fun getRealInput(): List<Int> {
        val line = Day07::class.java.classLoader.getResource("day07.txt")?.readText()?.lines()?.get(0)
            ?: fail()
        return line.split(",").map { it.toInt() }
    }
}