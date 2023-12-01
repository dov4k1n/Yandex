fun main() {
    val a = readLine()?.toInt() ?: 0
    val b = readLine()?.toInt() ?: 0
    val c = readLine()?.toInt() ?: 0

    println(solve(a, b, c))
}

fun solve(a: Int, b: Int, c: Int): String {
    if (c < 0) return "NO SOLUTION"
    
    if (a == 0) return if (b == c*c) "MANY SOLUTIONS" else "NO SOLUTION"

    val ax = c*c - b

    if (ax % a == 0) return (ax/a).toString()

    return "NO SOLUTION"
}