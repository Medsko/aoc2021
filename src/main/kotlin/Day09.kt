class Day09 {

    private val green = "\u001b[0;32m"
    private val blue = "\u001b[0;34m"

    fun part1(lines: List<List<Int>>): Int {
        val lowPoints = determineLowPointsByPositions(lines)
        return lowPoints.sumOf { it + 1 }
    }

    fun part2(lines: List<List<Int>>): Int {
        val allBasins = determineBasins(lines)
        printBasins(lines, allBasins.flatten())
        return calculateAnswerPart2(allBasins)
    }

    private fun calculateAnswerPart2(basins: List<Set<Pair<Int, Int>>>): Int {
        return basins.map { it.size }.sorted().subList(basins.size - 3, basins.size)
            .reduce { acc, next -> acc * next}
    }

    private fun determineBasins(lines: List<List<Int>>): MutableList<Set<Pair<Int, Int>>> {
        val lowPositions = determineLowPositions(lines)
        val allBasins = mutableListOf<Set<Pair<Int, Int>>>()
        for (lowPosition in lowPositions) {
            val higherPositions = mutableSetOf<Pair<Int, Int>>()
            determineAdjacentHighPoints(lowPosition, lines, higherPositions)
            allBasins.add(higherPositions)
        }
        return allBasins
    }

    private fun printBasins(lines: List<List<Int>>, basins: List<Pair<Int, Int>>) {
        for (y in lines.indices) {
            for (x in lines[y].indices) {
                if (basins.contains(Pair(y, x))) {
                    print(blue + lines[y][x])
                } else {
                    print(green + lines[y][x])
                }
            }
            println()
        }
    }

    fun determineAdjacentHighPoints(position: Pair<Int, Int>, lines: List<List<Int>>, higher: MutableSet<Pair<Int, Int>>) {
        val higherPoints = mutableListOf<Pair<Int, Int>>()
        for (yMod in -1..1) {
            for (xMod in -1..1) {
                if (xMod != 0 && yMod != 0) continue   // Disregard diagonal positions
                val yIndex = position.first + yMod
                val xIndex = position.second + xMod
                val point = lines[position.first][position.second]
                if (xIndex == -1 || yIndex == -1 || yIndex == lines.size || xIndex == lines[yIndex].size) continue
                if (lines[yIndex][xIndex] == 9 || point >= lines[yIndex][xIndex]) continue
                higherPoints.add(Pair(yIndex, xIndex))
            }
        }
        for (higherPoint in higherPoints) {
            determineAdjacentHighPoints(higherPoint, lines, higher)
        }
        higher.add(position)
    }

    fun determineLowPointsByPositions(lines: List<List<Int>>): List<Int> {
        val lowPositions = determineLowPositions(lines)
        val lowPoints = mutableListOf<Int>()
        for (lowPosition in lowPositions) {
            lowPoints.add(lines[lowPosition.first][lowPosition.second])
        }
        return lowPoints
    }

    fun determineLowPositions(lines: List<List<Int>>): List<Pair<Int, Int>> {
        val lowPoints = mutableListOf<Pair<Int, Int>>()
        for (yIndex in lines.indices) {
            for (xIndex in 0 until lines[yIndex].size) {
                val point = lines[yIndex][xIndex]
                if (xIndex != 0 && point >= lines[yIndex][xIndex-1]) continue
                if (xIndex != lines[yIndex].size - 1 && point >= lines[yIndex][xIndex+1]) continue
                if (yIndex != 0 && point >= lines[yIndex-1][xIndex]) continue
                if (yIndex != lines.size - 1 && point >= lines[yIndex+1][xIndex]) continue
                lowPoints.add(Pair(yIndex, xIndex))
            }
        }
        return lowPoints
    }
}