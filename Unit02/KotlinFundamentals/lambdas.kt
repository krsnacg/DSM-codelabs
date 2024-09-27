fun main() {
    
    val cupcake: (Int) -> String = { 
        "Have a cupcake!"
    }
    
    val trickFunction = trickOrTreat(false) { "$it quarters" }
    val treatFunction = trickOrTreat(true, null)
    trickFunction()
    repeat(4) {
        treatFunction()
    }
}

fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int)-> String)?): () -> Unit {
    if (isTrick)
    	return trick
    else{
        if (extraTreat != null)
        	println(extraTreat(5))
        return treat
    }
}

val trick = {
    println("No treats!")
}

val treat: () -> Unit = {
    println("Have a treat!")
}