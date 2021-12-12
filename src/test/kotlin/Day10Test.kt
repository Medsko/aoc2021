import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day10Test {

    private val interpreter = Day10()

    @Test
    internal fun validate() {
        assertEquals(0, interpreter.validate("[<>({}){}[([])<>]]"))
        assertEquals(1197, interpreter.validate("{([(<{}[<>[]}>{[]{[(<()>"))
        assertEquals(3, interpreter.validate("[[<[([]))<([[{}[[()]]]"))
        assertEquals(57, interpreter.validate("[{[{({}]{}}([{[{{{}}([]"))
        assertEquals(3, interpreter.validate("[<(<(<(<{}))><([]([]()"))
        assertEquals(25137, interpreter.validate("<{([([[(<>()){}]>(<<{{"))
    }

    @Test
    internal fun part1TestRun() {
        val result = interpreter.part1(getTestInputForDay(10))
        assertEquals(26397, result)
    }

    @Test
    internal fun part1ForReal() {
        val result = interpreter.part1(getRealInputForDay(10))
        assertEquals(311949, result)
    }

    @Test
    internal fun part2TestRun() {
        val result = interpreter.part2(getTestInputForDay(10))
        assertEquals(288957, result)
    }

    @Test
    internal fun part2ForReal() {
        val result = interpreter.part2(getRealInputForDay(10))
        assertEquals(3042730309, result)
    }

    @Test
    internal fun findUnclosedTokens() {
        assertEquals("<{([", interpreter.findUnclosedTokens("<{([{{}}[<[[[<>{}]]]>[]]").joinToString(""))
        assertEquals("[({([[{{", interpreter.findUnclosedTokens("[({(<(())[]>[[{[]{<()<>>").joinToString(""))
    }

}