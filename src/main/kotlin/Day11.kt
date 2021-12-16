class Day11 {

    private val green = "\u001b[0;32m"
    private val black = "\u001b[0;30m"
    private val white = "\u001b[0;37m"

    fun part1(lines: List<List<Int>>, steps: Int): Int {
        val octopi = mutableListOf<MutableList<Int>>()
        lines.map { it.toMutableList() }.forEach { octopi.add(it) }
        var flashes = 0
        for (i in 1..steps) {
            flashes += updateOctopi(octopi)
            printOctopi(i, octopi)
            if (octopi.flatten().all { it == 0 }) return i
        }
        return flashes
    }

    private fun updateOctopi(octopi: MutableList<MutableList<Int>>): Int {
        var flashes = 0
        for (yIndex in octopi.indices) {
            for (xIndex in octopi[yIndex].indices) {
                octopi[yIndex][xIndex]++
            }
        }

        val flashing = mutableListOf<Pair<Int, Int>>()
        for (yIndex in octopi.indices) {
            for (xIndex in octopi[yIndex].indices) {
                // Determine which octopi will flash before processing the flashes to prevent double updates.
                if (octopi[yIndex][xIndex] == 10) {
                    flashing.add(Pair(yIndex, xIndex))
                    flashes++
                }
            }
        }
        for (flashingOctopus in flashing) {
            flashes += incrementAdjacent(octopi, flashingOctopus)
        }
        resetFlashingOctopi(octopi)
        return flashes
    }

    private fun resetFlashingOctopi(octopi: MutableList<MutableList<Int>>) {
        for (yIndex in octopi.indices) {
            for (xIndex in octopi[yIndex].indices) {
                if (octopi[yIndex][xIndex] == 10) octopi[yIndex][xIndex] = 0
            }
        }
    }

    private fun incrementAdjacent(octopi: MutableList<MutableList<Int>>, current: Pair<Int, Int>): Int {
        var flashes = 0
        for (yMod in -1..1) {
            for (xMod in -1..1) {
                if (xMod == 0 && yMod == 0) continue  // Skip current
                val y = current.first + yMod
                val x = current.second + xMod
                if (y == -1 || x == -1 || y == octopi.size || x == octopi[y].size) continue // Out of bounds
                if (octopi[y][x] == 10) continue

                octopi[y][x]++

                if (octopi[y][x] == 10) {
                    flashes++
                    flashes += incrementAdjacent(octopi, Pair(y, x))
                }
            }
        }
        return flashes
    }

    private fun printOctopi(step: Int, octopi: MutableList<MutableList<Int>>) {
        println(white + "Octopi state at step $step:")
        for (yIndex in octopi.indices) {
            for (xIndex in octopi[yIndex].indices) {
                val current = octopi[yIndex][xIndex]
                if (current == 0) print(white + current)
                else print(green + current)
            }
            println()
        }
    }

}