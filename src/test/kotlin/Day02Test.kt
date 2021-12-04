import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.fail
import org.junit.jupiter.api.Test

internal class Day02Test {

    private val submarine = Day02()

    @Test
    internal fun part1TestRun() {
        assertEquals(150, submarine.part1(getTestInput()))
    }

    @Test
    internal fun part1ForReal() {
        assertEquals(1698735, submarine.part1(getRealInput()))
    }

    @Test
    internal fun part2TestRun() {
        assertEquals(900, submarine.part2(getTestInput()))
    }

    @Test
    internal fun part2ForReal() {
        assertEquals(1594785890, submarine.part2(getRealInput()))
    }

    private fun getTestInput(): List<String> {
        return listOf("forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2")
    }

    private fun getRealInput(): List<String> {
        return Day01::class.java.classLoader.getResource("day02.txt")?.readText()?.lines() ?: fail()
    }
}