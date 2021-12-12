class Day09 {

    fun part1(lines: List<String>): Int {
        val lowPoints = determineLowPoints(lines)
        return lowPoints.sumOf { it + 1 }
    }

    fun determineLowPoints(lines: List<String>): MutableList<Int> {
        var previous: List<Int>? = null
        val lowPoints = mutableListOf<Int>()
        for ((index, line) in lines.withIndex()) {
            val next = if (index == lines.size - 1) null else toIntList(lines[index + 1])
            lowPoints.addAll(determineLowPointsForLine(line, previous, next))
            previous = toIntList(line)
        }
        return lowPoints
    }

    private fun determineLowPointsForLine(current: String, previous: List<Int>?, next: List<Int>?): List<Int> {
        val points = toIntList(current)
        val lowPoints = mutableListOf<Int>()
        for ((index, point) in points.withIndex()) {
            if (index != 0 && point >= points[index-1]) continue
            if (index != points.size -1 && point >= points[index+1]) continue
            if (previous != null && point >= previous[index]) continue
            if (next != null && point >= next[index]) continue
            lowPoints.add(point)
        }
        return lowPoints
    }

    private fun toIntList(numbers: String) = numbers.toCharArray().map { Character.getNumericValue(it) }



}