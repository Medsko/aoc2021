import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import kotlin.test.fail

internal class Day01Test {

    @Test
    internal fun part1TestRun() {
        val input = listOf(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)
        assertEquals(7, Day01().part1(input))
    }

    @Test
    internal fun part1ForReal() {
        assertEquals(1559, Day01().part1(getRealInput()))
    }

    @Test
    internal fun part2TestRun() {
        val input = listOf(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)
        assertEquals(5, Day01().part2(input))
    }

    @Test
    internal fun part2ForReal() {
        assertEquals(1600, Day01().part2(getRealInput()))
    }

    @Test
    internal fun readInput() {
        val file = Day01::class.java.classLoader.getResource("day01.txt")
        assertNotNull(file)
        assertEquals(2000, file?.readText()?.lines()?.size)
    }

    private fun getRealInput(): ArrayList<Int> {
        return Day01::class.java.classLoader.getResource("day01.txt")?.readText()?.lines()
            ?.map { it.toInt() }?.toCollection(ArrayList())
            ?: fail()
    }
}