fun main() {
    val sequence = mutableListOf<Int>()
    var input = readLine()!!.toInt()

    while (input != -2000000000) {
        sequence.add(input)
        input = readLine()!!.toInt()
    }

    println(findSequenceType(sequence))
}

// not working
// fun findSequenceTypeShorter(sequence: List<Int>): String {
//     var countConstant = 0
//     var countAscending = 0
//     var countWeaklyAscending = 0
//     var countDescending = 0
//     var countWeaklyDescending = 0

//     for (i in 0 until sequence.size - 1) {
//         if (sequence[i+1] == sequence[i]) countConstant++
//         else if (sequence[i+1] > sequence[i]) countAscending++
//         else if (sequence[i+1] >= sequence[i]) countWeaklyAscending++
//         else if (sequence[i+1] < sequence[i]) countDescending++
//         else if (sequence[i+1] <= sequence[i]) countWeaklyDescending++
//     }

//     if (countConstant == sequence.size - 1) return "CONSTANT"
//     if (countAscending == sequence.size - 1) return "ASCENDING"
//     if (countWeaklyAscending == sequence.size - 1) return "WEAKLY ASCENDING"
//     if (countDescending == sequence.size - 1) return "DESCENDING"
//     if (countWeaklyDescending == sequence.size - 1) return "WEAKLY DESCENDING"
//     return "RANDOM"
// }

fun findSequenceType(sequence: List<Int>): String {
    //println(sequence)

    if (isConstant(sequence))
        return "CONSTANT"

    if (isAscending(sequence))
        return "ASCENDING"

    if (isWeaklyAscending(sequence))
        return "WEAKLY ASCENDING"
    
    if (isDescending(sequence))
        return "DESCENDING"

    if (isWeaklyDescending(sequence))
        return "WEAKLY DESCENDING"
    
    return "RANDOM"
}

fun isConstant(sequence: List<Int>): Boolean {
    for (i in 0 until sequence.size - 1)
        if (sequence[i+1] != sequence[i]) {
            //println("not constant: ${sequence[i+1]} != ${sequence[i]}")
            return false
        }

    return true
}

fun isAscending(sequence: List<Int>): Boolean {
    for (i in 0 until sequence.size - 1)
        if (sequence[i+1] <= sequence[i]) {
            //println("not ascending: ${sequence[i+1]} <= ${sequence[i]}")
            return false
        }

    return true
}

fun isWeaklyAscending(sequence: List<Int>): Boolean {
    for (i in 0 until sequence.size - 1)
        if (sequence[i+1] < sequence[i]) {
            //println("not weakly ascending: ${sequence[i+1]} < ${sequence[i]}")
            return false
        }

    return true
}

fun isDescending(sequence: List<Int>): Boolean {
    for (i in 0 until sequence.size - 1)
        if (sequence[i+1] >= sequence[i]) {
            //println("not descending: ${sequence[i+1]} >= ${sequence[i]}")
            return false
        }

    return true
}

fun isWeaklyDescending(sequence: List<Int>): Boolean {
    for (i in 0 until sequence.size - 1)
        if (sequence[i+1] > sequence[i]) {
            //println("not weakly descending: ${sequence[i+1]} > ${sequence[i]}")
            return false
        }

    return true
}