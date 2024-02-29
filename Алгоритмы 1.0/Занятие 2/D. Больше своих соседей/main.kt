fun main() {
    val list = readLine()!!.split(" ").map { it.toInt() }

    println(countNeighboursMaxs(list))
}

fun countNeighboursMaxs(list: List<Int>): Int {
    var ans = 0

    for (i in 1 until list.size - 1) {
        if (list[i-1] < list[i] && list[i+1] < list[i])
            ans++
    }

    return ans
}