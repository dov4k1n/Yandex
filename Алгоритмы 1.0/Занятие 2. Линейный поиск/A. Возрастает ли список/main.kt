fun main() {
    val list = readLine()?.split(" ")?.map { it.toDouble() } ?: emptyList()

    for (i in 0 until list.size - 1)
        if (list[i+1] <= list[i]) {
            println("NO")
            return
        }

    println("YES")
}