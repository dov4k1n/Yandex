import kotlin.comparisons.maxOf

fun main() {
    val (a, b, c, d) = readLine()!!.split(" ").map { it.toInt() }

    val triple: MutableList<Triple<Int, Int, Int>> = MutableList(4) { Triple(0, 0, 0) }

    triple[0] = Triple(a, c, b + d)
    triple[1] = Triple(a, d, b + c)
    triple[2] = Triple(b, c, a + d)
    triple[3] = Triple(b, d, a + c)

    var min = maxOf(triple[0].first, triple[0].second) * triple[0].third
    var minIndex = 0

    for (i in 1..3) {
        var tmp = maxOf(triple[i].first, triple[i].second) * triple[i].third

        if (tmp < min) {
            minIndex = i
            min = tmp
        }
    }

    println("${maxOf(triple[minIndex].first, triple[minIndex].second)} ${triple[minIndex].third}")
}