import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.fail
import org.junit.jupiter.api.Test

internal class Day03Test {

    private val diagnosis = Day03()

    @Test
    internal fun part1TestRun() {
        assertEquals(198, diagnosis.part1(getTestInput()))
    }

    @Test
    internal fun part1ForReal() {
        assertEquals(3277364, diagnosis.part1(getRealInput()))
    }

    @Test
    internal fun part2TestRun() {
        assertEquals(230, diagnosis.part2(getTestInput()))
    }

    @Test
    internal fun part2ForReal() {
        assertEquals(5736383, diagnosis.part2(getRealInput()))
    }

    @Test
    internal fun determineAndKeepMostCommon() {
        val mostCommon = diagnosis.determineAndKeep(getTestInput(), true)
        assertEquals(1, mostCommon.size)
        assertEquals(23, Integer.parseInt(mostCommon[0], 2))
    }

    @Test
    internal fun determineAndKeepLeastCommon() {
        val leastCommon = diagnosis.determineAndKeep(getTestInput(), false)
        assertEquals(1, leastCommon.size)
        assertEquals(10, Integer.parseInt(leastCommon[0], 2))
    }

    @Test
    internal fun parseBinary() {
        assertEquals(22, Integer.parseInt("10110", 2))
        assertEquals(31, Integer.parseInt("11111", 2))
    }

    @Test
    internal fun parseHex() {
        // Just wanted to check if I could still parse simple hexes. I couldn't :(but will probably do better next time:)
        assertEquals(31, Integer.parseInt("1f", 16))
        assertEquals(16, Integer.parseInt("10", 16))
        assertEquals(15, Integer.parseInt("f", 16))
    }

    @Test
    internal fun parseNumericChar() {
        assertEquals(1, Character.getNumericValue("1"[0]))
        assertEquals(0, Character.getNumericValue("0"[0]))
    }

    private fun getTestInput(): List<String> {
        return Day01::class.java.classLoader.getResource("example/day03.txt")?.readText()?.lines() ?: fail()
    }

    private fun getRealInput(): List<String> {
        return Day01::class.java.classLoader.getResource("day03.txt")?.readText()?.lines() ?: fail()
    }
}