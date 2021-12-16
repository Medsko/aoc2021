import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day11Test {

    private val drOcto = Day11()

    @Test
    internal fun part1TestRun() {
        drOcto.part1(getTestInputAsIntsForDay(11), 2)
        val input = getTestInputAsIntsForDay(11)
        assertEquals(204, drOcto.part1(input, 10))
        assertEquals(1656, drOcto.part1(input, 100))
    }

    @Test
    internal fun part1ForReal() {
        val input = getRealInputAsIntsForDay(11)
        assertEquals(1647, drOcto.part1(input, 100))
    }

    @Test
    internal fun part2TestRun() {
    }

    @Test
    internal fun part2ForReal() {
    }
}