import kotlin.math.min
import kotlin.math.max

fun main() {
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val c = readLine()!!.toInt()
    val d = readLine()!!.toInt()
    val e = readLine()!!.toInt()

    var A = min(a, b)
    var B = max(a, b)
    var C = max(B, c)
    B = min(B, c)
    A = min(A, B)
    var D = min(d, e)
    var E = max(d, e)

    if (A <= D && B <= E)
        println("YES")
    else
        println("NO")

    // if (a <= d && b <= e || a <= e && b <= d)
    //     println("YES")
    // else if (c <= d && b <= e || c <= e && b <= d)
    //     println("YES")
    // else if (a <= d && c <= e || a <= e && c <= d)
    //     println("YES")
    // else
    //     println("NO")
}