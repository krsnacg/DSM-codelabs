class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double
)

val cookies = listOf(
    Cookie(
        name = "Chocolate Chip",
        softBaked = false,
        hasFilling = false,
        price = 1.69
    ),
    Cookie(
        name = "Banana Walnut", 
        softBaked = true, 
        hasFilling = false, 
        price = 1.49
    ),
    Cookie(
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price = 1.59
    ),
    Cookie(
        name = "Chocolate Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie(
        name = "Snickerdoodle",
        softBaked = true,
        hasFilling = false,
        price = 1.39
    ),
    Cookie(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)

// The map() function lets you transform a collection into a new collection with the same number of elements.
// For example, map() could transform a List<Cookie> into a List<String> only containing the cookie's name, 
// provided you tell the map() function how to create a String from each Cookie item.
val fullMenu = cookies.map {
    "${it.name} - $${it.price}"
}

// The filter() function lets you create a subset of a collection. For example, if you had a list of numbers,
// you could use filter() to create a new list that only contains numbers divisible by 2. Unlike map(), 
// the resulting collection also has the same data type, so filtering a List<Cookie> will result in another List<Cookie>.
val softBakedMenu = cookies.filter {
    it.softBaked
}

// The groupBy() function can be used to turn a list into a map, based on a function. 
// Each unique return value of the function becomes a key in the resulting map. 
// The values for each key are all the items in the collection that produced that unique return value.
val groupedMenu = cookies.groupBy {
    it.softBaked
}
val softBakedM = groupedMenu[true] ?: listOf()
val crunchyMenu = groupedMenu[false] ?: listOf()

// The fold() function is used to generate a single value from a collection. 
// This is most commonly used for things like calculating a total of prices, 
// or summing all the elements in a list to find an average.
val totalPrice = cookies.fold(0.0) { total, cookie ->
    total + cookie.price
} // NOTE: Note: fold() is sometimes called reduce(). The fold() function in Kotlin works the same 
// as the reduce() function found in JavaScript, Swift, Python, etc. Note that Kotlin also has its 
// own function called reduce(), where the accumulator starts with the first element in the collection, 
// rather than an initial value passed as an argument.

// sortedBy() lets you specify a lambda that returns the property you'd like to sort by. For example, 
// if you'd like to sort by price, the lambda would return it.price. So long as the data type of the 
// value has a natural sort order—strings are sorted alphabetically, numeric values are sorted
// in ascending order—it will be sorted just like a collection of that type.
val alphabeticalMenu = cookies.sortedBy {
    it.name
}

fun main() {
    println("Full menu:")
    fullMenu.forEach {
        println(it)
    }
    
    println("\nSoft cookies:")
	softBakedMenu.forEach {
    	println("${it.name} - $${it.price}")
	}
    
    println("\nSoft cookies:")
    softBakedM.forEach {
        println("${it.name} - $${it.price}")
    }
    println("Crunchy cookies:")
    crunchyMenu.forEach {
        println("${it.name} - $${it.price}")
    }

    println("\nTotal prince: $${totalPrice}")
    
    println("\nAlphabetical menu:")
    alphabeticalMenu.forEach {
        println(it.name)
    }
}
