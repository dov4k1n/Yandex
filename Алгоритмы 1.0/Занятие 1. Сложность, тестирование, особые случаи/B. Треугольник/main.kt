fun main() {
    val a: Int? = readLine()?.toIntOrNull()
    val b: Int? = readLine()?.toIntOrNull()
    val c: Int? = readLine()?.toIntOrNull()

    if (a != null && b != null && c != null) {
        val b1 = a + b > c
        val b2 = a + c > b
        val b3 = b + c > a

        if (b1 && b2 && b3) {
            println("YES")
        } else {
            println("NO")
        }
    } else {
        println("Invalid input. Please enter valid integer values.")
    }
}
