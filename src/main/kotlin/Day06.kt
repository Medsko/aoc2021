class Day06 {

    fun part1(initialFish: List<Int>, days: Int): Int {
        var lanternFish = initialFish
        for (i in 1..days) {
            val birthingFish = lanternFish.filter { it == 0 }.map { 8 }
            lanternFish = lanternFish.map { if (it > 0) it - 1 else 6 }
            lanternFish = lanternFish + birthingFish
        }
        return lanternFish.count()
    }

    fun part2(initialFish: List<Int>, days: Int): Long {
        val breedingGround = mutableMapOf<Int, Long>()
        for (i in initialFish) breedingGround[i] = (breedingGround[i] ?: 0) + 1
        for (i in 1..days) {
            val birthing = breedingGround[0] ?: 0
            for (counter in 1..8) {
                breedingGround[counter-1] = breedingGround[counter] ?: 0
            }
            // Reset counter for fish giving birth
            breedingGround[6] = (breedingGround[6] ?: 0) + birthing
            // Add newborns
            breedingGround[8] = birthing
        }
        return breedingGround.values.sum()
    }

}