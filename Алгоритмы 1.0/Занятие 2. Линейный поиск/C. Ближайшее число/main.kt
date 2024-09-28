import kotlin.math.abs

fun main() {
    val size = readLine()!!.toInt() // 1..1000
    val list = readLine()!!.split(" ").map { it.toInt() } // -1000..1000
    val number = readLine()!!.toInt() // -1000..1000

    println(findClosestElement(list, number))
}

fun findClosestElement(list: List<Int>, number: Int): Int {
    var ans: Int = list[0]
    var dist: Int = abs(list[0] - number)
    var newDist: Int

    for (element in list) {
        newDist = abs(element - number)
        if (newDist < dist) {
            ans = element
            dist = newDist
        }
    }

    return ans
}