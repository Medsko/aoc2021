import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

internal class Day04Test {

    private val squidGame = Day04()

    @Test
    internal fun part1TestRun() {
        val answer = squidGame.part1(getTestInput())
        assertEquals(4512, answer)
    }

    @Test
    internal fun part1ForReal() {
        val answer = squidGame.part1(getRealInput())
        assertEquals(39902, answer)
    }

    @Test
    internal fun part2TestRun() {
        val answer = squidGame.part2(getTestInput())
        assertEquals(1924, answer)
    }

    @Test
    internal fun part2ForReal() {
        val answer = squidGame.part2(getRealInput())
        assertEquals(26936, answer)
    }

    @Test
    internal fun parseInput() {
        val (drawnNumbers, bingoCards) = squidGame.parseInput(getTestInput())
        assertAll(
            Executable { assertEquals(bingoCards.size, 3) },
            Executable { assertEquals(300, bingoCards[0].remainder()) },
            Executable { assertEquals(7, drawnNumbers[0]) }
        )
    }

    private fun getTestInput(): List<String> {
        return Day01::class.java.classLoader.getResource("example/day04.txt")?.readText()?.lines() ?: fail()
    }

    private fun getRealInput(): List<String> {
        return Day01::class.java.classLoader.getResource("day04.txt")?.readText()?.lines() ?: fail()
    }
}