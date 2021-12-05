class Day05 {
    private val points = mutableMapOf<Coordinate, Int>()

    fun part1(input: List<String>): Int {
        val coordinatePairs = parseInput(input)
        coordinatePairs.filter { it.first.isHorizontalOrVertical(it.second) }
            .flatMap { it.first..it.second }
            .forEach { coordinate -> points[coordinate] = (points.getOrPut(coordinate) { 0 }) + 1 }

        return points.filter { it.value > 1 }.count()
    }

    fun part2(input: List<String>): Int {
        val coordinatePairs = parseInput(input)
        coordinatePairs.flatMap { it.first..it.second }
            .forEach { coordinate -> points[coordinate] = (points.getOrPut(coordinate) { 0 }) + 1 }

        return points.filter { it.value > 1 }.count()
    }

    fun parseInput(input: List<String>): List<Pair<Coordinate, Coordinate>> {
        return input.map {
            val parts = it.split("\\s+".toRegex())
            val fromString = parts[0].split(",")
            val toString = parts[2].split(",")
            val from = Coordinate(fromString[0].toInt(), fromString[1].toInt())
            val to = Coordinate(toString[0].toInt(), toString[1].toInt())
            Pair(from, to)
        }
    }
}

data class Coordinate(val x: Int, val y: Int) : Comparable<Coordinate> {

    override fun compareTo(other: Coordinate): Int {
        return if (this.x.compareTo(other.x) != 0) this.x.compareTo(other.x)
        else this.y.compareTo(other.y)
    }

    fun isHorizontalOrVertical(other: Coordinate): Boolean {
        return this.x == other.x || this.y == other.y
    }

    operator fun rangeTo(endInclusive: Coordinate) = CoordinateRange(this, endInclusive)

    operator fun plus(other: Coordinate): Coordinate = Coordinate(this.x + other.x, this.y + other.y)

    class CoordinateRange(override val start: Coordinate, override val endInclusive: Coordinate) :
        ClosedRange<Coordinate>, Iterable<Coordinate> {

        override fun iterator(): Iterator<Coordinate> {
            return if (start < endInclusive) CoordinateIterator(start, endInclusive)
            else CoordinateIterator(endInclusive, start)
        }
    }

    class CoordinateIterator(start: Coordinate, endInclusive: Coordinate) : Iterator<Coordinate> {
        private val direction = Coordinate(endInclusive.x.compareTo(start.x), endInclusive.y.compareTo(start.y))
        private val endExclusive = endInclusive + direction
        var current = start

        override fun hasNext(): Boolean {
            return current != endExclusive
        }

        override fun next(): Coordinate {
            val next = current
            current += direction

            return next
        }
    }
}