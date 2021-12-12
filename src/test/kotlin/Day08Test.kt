import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day08Test {

    private val clockwork = Day08()

    @Test
    internal fun parseInput() {
        val parsed = clockwork.parseInput(getTestInput())
        assertEquals(10, parsed.size)
        assertEquals(listOf("fdgacbe", "cefdb", "cefbgd", "gcbe"), parsed[0].second)
    }

    @Test
    internal fun part1TestRun() {
        val combinations = clockwork.parseInput(getTestInput()).map { it.second }
        assertEquals(26, clockwork.part1(combinations))
    }

    @Test
    internal fun part1ForReal() {
        val combinations = clockwork.parseInput(getRealInput()).map { it.second }
        assertEquals(445, clockwork.part1(combinations))
    }

    @Test
    internal fun part2TestRun() {
        val combinations = clockwork.parseInput(getTestInput())
        assertEquals(61229, clockwork.part2(combinations))
    }

    @Test
    internal fun part2ForReal() {
        val combinations = clockwork.parseInput(getRealInput())
        assertEquals(1043101, clockwork.part2(combinations))
    }

    @Test
    internal fun translateCombinations() {
        val combinations = listOf("acedgfb", "cdfbe", "gcdfa", "fbcad", "dab", "cefabd", "cdfgeb", "eafb", "cagedb", "ab")
        val translated = clockwork.mapCombinationToValue(combinations)
        assertEquals("6", translated[sortAlphabetically("cdfgeb")])
        assertEquals("9", translated[sortAlphabetically("cefabd")])
        assertEquals("5", translated[sortAlphabetically("cdfbe")])
        assertEquals("2", translated[sortAlphabetically("gcdfa")])
        assertEquals("3", translated[sortAlphabetically("fbcad")])
        assertEquals("0", translated[sortAlphabetically("cagedb")])
    }

    private fun sortAlphabetically(input: String): String {
        return input.toCharArray().sorted().joinToString("")
    }

    private fun getTestInput(): List<String> {
        return Day01::class.java.classLoader.getResource("example/day08.txt")?.readText()?.lines() ?: Assertions.fail()
    }

    private fun getRealInput(): List<String> {
        return Day01::class.java.classLoader.getResource("day08.txt")?.readText()?.lines() ?: Assertions.fail()
    }
}