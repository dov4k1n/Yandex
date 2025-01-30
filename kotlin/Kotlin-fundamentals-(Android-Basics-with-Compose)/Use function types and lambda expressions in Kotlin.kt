val trick = {
    println("No treats!")
}

val treat = {
    println("Have a treat!")
}

fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    if (isTrick) {
        return trick
    } else {
        if (extraTreat != null) {
            println(extraTreat(5))
        }
        return treat
    }
}

fun main() {
    val coins: (Int) -> String = {
        "$it quarters"
    }

    val trickFunction = trickOrTreat(true, null)
    trickFunction()
    
    val treatFunction = trickOrTreat(false, coins)
    val treatFunction2 = trickOrTreat(false, { "$it quarters" }) // Pass a lambda expression directly into a function
    val treatFunction3 = trickOrTreat(false) { "$it quarters" } // trailing lambda syntax
    
    treatFunction()
    treatFunction2()
    treatFunction3()
    
    repeat(4) {
        trickFunction()
    }
    
    /*
     * fun repeat(times: Int, action: (Int) -> Unit)
     * 
     * */
}