// ещё не работает
fun main() {
    val game1 = readLine() // 0..5 : 0..5
    val game2 = readLine() // 0..5 : 0..5
    val homeOrAway = readLine() // 1 or 2

    println(calculateGoals(game1, game2, homeOrAway))
}

fun calculateGoals(game1: String?, game2: String?, homeOrAway: String?): Int {
    val (aG1, bG1) = game1!!.split(":").map { it.toInt() }
    val (aG2, bG2) = game2!!.split(":").map { it.toInt() }
    val aWasHome = homeOrAway == "1"

    if (bG1 == 0 && bG2 == 0)
        if (aG1 == 0 && aG2 == 0)
            return 1
    
    if (aG1 + aG2 <= bG1 + bG2) {
        if (ag1 <= bG1 && aWasHome)
            bG1 + bG2 - aG1 - aG2 + 1
        
    }
        return if (aWasHome) bG1 + bG2 - aG1 - aG2 else bG1 + bG2 - aG1 - aG2 + 1

    return 0
}