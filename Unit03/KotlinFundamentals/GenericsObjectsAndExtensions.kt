enum class Difficulty {
    EASY, MEDIUM, HARD
}

interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}

class Quiz: ProgressPrintable {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
	val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
	val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
    
    override val progressText: String
    	get() = "${answered} of ${total} answered"
    
    // Singleton class, companion object?
    companion object StudentProgress {
        val total = 10
        val answered = 3
    }
    
    override fun printProgressBar() {
        repeat(Quiz.answered) { print("▓") }
        repeat(Quiz.total - Quiz.answered) { print("▒") }
        println()
        println(progressText)
	}
    
    fun printQuiz() {
        // Scope functions
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

// Add an extension property
// val Quiz.StudentProgress.progressText: String
// 	get() = "${answered} of ${total} answered"

// Add an extension function
// fun Quiz.StudentProgress.printProgressBar() {
//     repeat(Quiz.answered) { print("▓") }
//     repeat(Quiz.total - Quiz.answered) { print("▒") }
//     println()
//     println(Quiz.progressText)
// }

// Classes like the Question class, on the other hand, only contain data.
// They don't have any methods that perform an action. These can be defined as a data class. 
// Defining a class as a data class allows the Kotlin compiler to make certain assumptions,
// and to automatically implement some methods. For example, toString() is called behind 
// the scenes by the println() function. When you use a data class, toString() and 
// other methods are implemented automatically based on the class's properties.
data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)


fun main() {
    Quiz().printProgressBar()
    // https://kotlinlang.org/docs/scope-functions.html
    Quiz().apply {
        printQuiz()
	}
}
