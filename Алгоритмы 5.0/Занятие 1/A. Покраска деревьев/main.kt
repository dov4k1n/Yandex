import kotlin.math.abs

fun main() {
    val (center1, radius1) = readLine()!!.split(" ").map { it.toInt() } // -10^8..10^8
    val (center2, radius2) = readLine()!!.split(" ").map { it.toInt() } // -10^8..10^8

    println(countPaintableTrees(center1, radius1, center2, radius2))
}

fun countPaintableTrees(center1: Int, radius1: Int, center2: Int, radius2: Int): Int {
    val left1 = center1 - radius1
    val right1 = center1 + radius1
    val left2 = center2 - radius2
    val right2 = center2 + radius2

    if (radius1 == 0 && radius2 == 0)
        return if (center1 == center2) 1 else 2
    if (radius1 == 0)
        return if (center1 == center2) abs(right2 - left2) + 1 else abs(right2 - left2) + 2
    if (radius2 == 0)
        return if (center1 == center2) abs(right1 - left1) + 1 else abs(right1 - left1) + 2

    if (left1 > left2) 
        return countPaintableTrees(center2, radius2, center1, radius1)

    var ans = 0

    ans += abs(right1 - left1) + 1 + abs(right2 - left2) + 1

    if (left2 <= right1 && right1 <= right2)
        ans -= right1 - left2 + 1
    else if (left2 <= right1 && right2 <= right1)
        ans -= right2 - left2 + 1

    return ans
}