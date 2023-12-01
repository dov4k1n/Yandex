fun calculate(input: List): String {
    if (input.size < 5) return "-1 -1"

    val flat1 = input[0].toInt() // 89
    val floorsCount = input[1].toInt() // 20
    val flat2 = input[2].toInt() // 41
    val entrance2 = input[3].toInt() // 1
    val floor2 = input[4].toInt() // 11
    // return entrance 2, floor 3

    val n = if (floor2 != 1) {
        (flat2 / (floor2-1)).toInt()
    }

    val floor1 = (flat / n).toInt() - floorsCount + 1
}

fun main() {
    val input = readLine()!!.split(" ")
    
    calculate(input)
}