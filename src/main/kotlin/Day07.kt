import kotlin.math.abs

class Day07 {

    fun part1(positions: List<Int>): Int {
        return positions.minByOrNull { calculateTotalDistance(it, positions) }
            ?: throw IllegalStateException("Minimal fuel usage could not be determined!")
    }

    fun part2(positions: List<Int>): Int {
        val triangularMap = getTriangularMap(positions)
        val max = positions.maxByOrNull { it } ?: 0
        val range = 0..max
        return range.map { calculateTotalTriangularDistance(it, positions, triangularMap) }
            .minByOrNull { it } ?: throw IllegalStateException("Minimal fuel usage could not be determined!")
    }

    fun calculateTotalTriangularDistance(goal: Int, positions: List<Int>, triangularMap: Map<Int, Int>): Int {
        return positions.map { abs(it - goal) }.sumOf { triangularMap[it] ?: Int.MAX_VALUE }
    }

    fun getTriangularMap(positions: List<Int>): Map<Int, Int> {
        val max = positions.maxByOrNull { it } ?: 0
        val triangularMap = mutableMapOf(0 to 0)
        for (i in 1..max) {
            triangularMap[i] = (triangularMap[i-1] ?: 0) + i
        }
        return triangularMap
    }

    fun calculateTotalDistance(goal: Int, positions: List<Int>): Int {
        return positions.sumOf { abs(it - goal) }
    }

}