/*define a limited set of possible values*/
enum class Difficulty {
    EASY, MEDIUM, HARD
}

interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}

/*<T> = Generics allow data types to be passed as parameters to classes*/
/*
 * Classes like the Question class, on the other hand, only contain data.
 * They don't have any methods that perform an action. 
 * These can be defined as a data class. 
 * Defining a class as a data class allows the Kotlin compiler to make 
 * certain assumptions, and to automatically implement some methods. 
 * For example, toString() is called behind the scenes by the println() function. 
 * When you use a data class, toString() and other methods are implemented 
 * automatically based on the class's properties.
 * 
 */
data class Question<T>(
	val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

class Quiz: ProgressPrintable {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
    
   	/*singleton*/ 
    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 7
    }
    
    override val progressText: String
    	get() = "${answered} of ${total} answered."
    
    override fun printProgressBar() {
        repeat(answered) { print("▓") }
        repeat(total - answered) { print("▒") }
        println()
        println(progressText)
        println()
    }
    
    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        
        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        
        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }
}

/*
val Quiz.StudentProgress.progressText: String
	get() = "${answered} of ${total} answered."

fun Quiz.StudentProgress.printProgressBar() {
    repeat(Quiz.answered) { print("▓") }
    repeat(Quiz.total - Quiz.answered) { print("▒") }
    println()
    println(Quiz.progressText)
}
*/

fun main() {
    /*
    Quiz.printProgrssBar()
    */
    Quiz().printProgressBar()
    /*val quiz =*/Quiz().apply {
        printQuiz()
    }
}