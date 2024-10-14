import kotlin.Array

fun main() {
    var k = 2
    while (k > 0) {
        notMain(k)
        k--
    }
    fibonacci(9)
    doubleType()
    stringType()
    escapeSequence()
    booleanType()
    otherConcatenation()
}

fun notMain(arg: Int) {
    val k_null: Array<Int?> = arrayOfNulls(3)
    for (i in k_null.indices) print(i)
    println("Hello, Android $arg")
}

fun fibonacci(n: Int) {
    if (n < 1) {
        println("Invalid number of terms\n")
        return
    }
    
    var prev1 = 1
    var prev2 = 0
    
    for (i in 1..n) {
        if (i > 2) {
            val num = prev1 + prev2
            prev2 = prev1
            prev1 = num
            print(num)
        }
        
        if (i == 1) print(prev2)
        if (i == 2) print(prev1)
    }
    println()
}

fun doubleType() {
    val trip1 = 3.20
    val trip2 = 4.10
    val trip3 = 1.72
    val totalTripLength = trip1 + trip2 + trip3
    println("$totalTripLength miles left to destination")
}

fun stringType() {
    val nextMeeting = "Next meeting: "
    val date = "January 1"
    val reminder = nextMeeting + date + " at work"
    println(reminder)
}

fun escapeSequence() {
    println("Say \"hello\"")
}

fun booleanType() {
    val notificationsEnabled: Boolean = true
    println(notificationsEnabled)
}
/*
 * Función que demuestra la concatenación de un string
 * con otros tipos de datos
 */
fun otherConcatenation() {
    val notificationsEnabled = false
    val notifNum = 2
    println("Are notifications enabled? " + notificationsEnabled)
    var concat ="Are " + notifNum + " notificacions enabled? " + notificationsEnabled
    println(concat)
}