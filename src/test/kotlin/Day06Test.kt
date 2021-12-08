import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.fail
import org.junit.jupiter.api.Test

internal class Day06Test {

    private val lanturn = Day06()

    @Test
    internal fun part1TestRun() {
        val lanternFish = "3,4,3,1,2".split(",").map { it.toInt() }

        assertEquals(5934, lanturn.part1(lanternFish, 80))
    }

    @Test
    internal fun part1ForReal() {
        val initialFish = getRealInput()
        assertEquals(395627, lanturn.part1(initialFish, 80))
    }

    @Test
    internal fun part2TestRun() {
        val lanternFish = "3,4,3,1,2".split(",").map { it.toInt() }
        assertEquals(26984457539, lanturn.part2(lanternFish, 256))
    }

    @Test
    internal fun part2ForReal() {
        assertEquals(1767323539209, lanturn.part2(getRealInput(), 256))
    }

    private fun getRealInput(): List<Int> {
        val line = Day06::class.java.classLoader.getResource("day06.txt")?.readText()?.lines()?.get(0)
            ?: fail()
        return line.split(",").map { it.toInt() }
    }
}
