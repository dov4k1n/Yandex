// ещё не работает

fun main() {
    val n = readLine()!!.toInt() // 3..100 000
    val ranges = readLine()!!.split(" ").map { it.toInt() } // 1..1000

    println(findVasilyHighestPlace(ranges))
}

fun findVasilyHighestPlace(ranges: List<Int>): Int {
    var winner = ranges[0]
    var vasily = 0
    var vasilysPlace = 0

    for (i in 1 until ranges.size - 1) {  
        if (ranges[i] > winner)
            winner = ranges[i]
        
        else if (
            ranges[i] % 5 == 0 && 
            ranges[i] % 10 != 0 && 
            ranges[i] <= winner && 
            ranges[i+1] < ranges[i]
        )
            vasily = ranges[i]
    }

    for (range in ranges)
        if (range > vasily)
            vasilysPlace++

    return vasilysPlace
}