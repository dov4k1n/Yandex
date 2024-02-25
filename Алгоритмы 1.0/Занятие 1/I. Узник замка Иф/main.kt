fun main() {
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val c = readLine()!!.toInt()
    val d = readLine()!!.toInt()
    val e = readLine()!!.toInt()

    if (a <= d && b <= e || a <= e && b <= d)
        println("YES")
    else if (c <= d && b <= e || c <= e && b <= d)
        println("YES")
    else if (a <= d && c <= e || a <= e && c <= d)
        println("YES")
    else
        println("NO")
}