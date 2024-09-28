import kotlin.math.min
import kotlin.math.max

fun main() {
    var a = readLine()!!.toInt() // in 1..1000
    // 1
    // 1
    var b = readLine()!!.toInt() // in 1..1000
    // 3
    // 5
    var n = readLine()!!.toInt() // in 1..1000
    // 3
    // 1
    var m = readLine()!!.toInt() // in 1..1000
    // 2
    // 2

    val minA = n + a*(n-1)
    val minB = m + b*(m-1)
    
    val maxA = n + a*(n+1)
    val maxB = m + b*(m+1)

    val min = max(minA, minB)
    val max = min(maxA, maxB)

    if (min > max)
        println("-1")
    else
        println("$min $max")
    // 5 7
    // -1
}