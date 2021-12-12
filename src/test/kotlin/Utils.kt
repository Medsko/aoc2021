import org.junit.jupiter.api.Assertions

fun getTestInputForDay(day: Int): List<String> =
    Day01::class.java.classLoader.getResource("example/day%02d.txt".format(day))?.readText()?.lines() ?: Assertions.fail()

fun getRealInputForDay(day: Int): List<String> =
    Day01::class.java.classLoader.getResource("day%02d.txt".format(day))?.readText()?.lines() ?: Assertions.fail()

fun getTestInputAsIntsForDay(day: Int): List<List<Int>> =
    getTestInputForDay(day).map { it.split("").map { number -> number.toInt() } }

fun getRealInputAsIntsForDay(day: Int): List<List<Int>> =
    getRealInputForDay(day).map { it.split("").map { number -> number.toInt() } }
