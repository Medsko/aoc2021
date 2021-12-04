class Day01 {

    // To do this, count the number of times a depth measurement increases from the previous measurement.
    // (There is no measurement before the first measurement.)

    fun part1(depths: List<Int>): Int {
        var previous = Int.MAX_VALUE
        var increases = 0
        depths
            .forEach {
                if (it > previous) increases++
                previous = it
            }
        return increases
    }

    fun part2(depths: List<Int>): Int {
        val sums = ArrayList<Int>()
        for (i in 0 until depths.size - 2) {
            sums.add(depths[i] + depths[i+1] + depths[i+2])
        }
        return part1(sums)
    }

}