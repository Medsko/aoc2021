class Day02 {

    private var depth = 0
    private var progress = 0
    private var aim = 0

    fun part1(instructions: List<String>): Int {
        val up = { amount: Int -> depth -= amount }
        val down = { amount: Int -> depth += amount}
        val forward = { amount: Int -> progress += amount }
        val instructionSet = hashMapOf(Pair("up", up), Pair("down", down), Pair("forward", forward))

        instructions.forEach { executeInstruction(it, instructionSet) }
        return depth * progress
    }

    fun part2(instructions: List<String>): Int {
        val up = { amount: Int -> aim -= amount }
        val down = { amount: Int -> aim += amount}
        val forward = { amount: Int -> progress += amount; depth += amount * aim}

        val instructionSet = hashMapOf(Pair("up", up), Pair("down", down), Pair("forward", forward))
        instructions.forEach { executeInstruction(it, instructionSet) }

        return depth * progress
    }

    private fun executeInstruction(instruction: String, instructionSet: Map<String, (Int) -> Unit>) {
        val parts = instruction.split(" ")
        val operation = parts[0]
        val amount = parts[1].toInt()
        instructionSet[operation]?.invoke(amount)
    }

}