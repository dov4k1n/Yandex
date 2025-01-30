fun main() {
    helloWorld()
    conditionals()

    val answerString = generateAnswerString(35)
    println(answerString)

    val answerString2 = generateAnswerString2(35)
    println(answerString2)

    val answerString3 = generateAnswerString3(35)
    println(answerString3)

    val StringLength: Int = stringLengthFunc("Android")
    println("$StringLength\n")

    val a = 5
    val b = 10
    val sumMessage = "The sum of $a and $b is ${a + b}.\n"
    println(sumMessage)

    var StringLength2 = stringMapper("Android", { input -> 
        input.length
    })
    println("$StringLength2\n")

    // or this way if the last parameter is anonymous function
    StringLength2 = stringMapper("iOS") { input ->
        input.length
    }
    println("$StringLength2\n")

    for (i in 0..10) {
        print("$i ")
    }
}

// higher-order function
fun stringMapper(str: String, mapper: (String) -> Int): Int {
    return mapper(str)
}

// anonymous function
val stringLengthFunc: (String) -> Int = { input ->
    input.length
}

fun generateAnswerString3(countThreshold: Int): String = if (countThreshold == 42) {
    "i have the answer.\n"
} else {
    "The answer eludes me.\n"
}

fun generateAnswerString2(countThreshold: Int): String {
    return if (countThreshold == 42) {
        "I have the answer.\n"
    } else {
        "The answer eludes me.\n"
    }
}

fun generateAnswerString(countThreshold: Int): String {
    val answerString = if (countThreshold == 42) {
        "I have the answer.\n"
    } else {
        "The answer eludes me.\n"
    }

    return answerString
}

fun conditionals() {
    var count: Int = 42

    if (count == 42) {
        println("I have the answer.\n")
    } else if (count > 35) {
        println("The answer is close.\n")
    } else {
        println("The answer eludes me.\n")
    }

    val answerString: String = if (count == 42) {
        "I have the answer.\n"
    } else if (count > 35) {
        "The answer is close.\n"
    } else {
        "The answer eludes me.\n"
    }
    println(answerString)

    val answerString2 = when {
        count == 42 -> "I have the answer.\n"
        count > 35 -> "The answer is close.\n"
        else -> "The answer eludes me.\n"
    }
    println(answerString2)

    val languageName: String? = null
    if (languageName != null) {
        println(languageName.uppercase())
    }
}

fun helloWorld() {
    println("Hello World!\n")
}