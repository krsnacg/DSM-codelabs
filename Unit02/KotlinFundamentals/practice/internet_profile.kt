fun main() {    
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)
    
    amanda.showProfile()
    atiqah.showProfile()
}


class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        val msg: String
        println("Name: $name\nAge: $age")
        if (referrer != null)
        	msg = "Has a referrer named ${referrer.name}, who likes to ${referrer.hobby}."
        else
        	msg = "Doesn't have a referrer"
        println("Likes to $hobby. " + msg)
    }
}
