fun main() {
    val solarSystem = mutableMapOf(
        "Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1,
        "Mars" to 2,
        "Jupiter" to 79,
        "Saturn" to 82,
        "Uranus" to 27,
        "Neptune" to 14
	)
    
	println(solarSystem.size)
    
    // You can use subscript syntax to set additional key-value pairs. Set the key "Pluto" to a value of 5.
	solarSystem["Pluto"] = 5
    
    // Print the size again, after inserting the element.
	println(solarSystem.size)
	
    // You can use subscript syntax to get a value. Print the number of moons for the key "Pluto".
	println(solarSystem.get("Theia"))
    
    // You can also access values with the get() method. Whether you use subscript syntax or call get(), 
    // it's possible that the key you pass in isn't in the map. If there isn't a key-value pair, 
    // it will return null. Print the number of moons for "Theia".
    println(solarSystem.get("Theia"))
    
    // The remove() method removes the key-value pair with the specified key. 
    // It also returns the removed value, or null, if the specified key isn't in the map.
    solarSystem.remove("Pluto")
	
    // To verify that the item was removed, print the size again.
    println(solarSystem.size)
    
    // Subscript syntax, or the put() method, can also modify a value for a key that already exists. 
    // Use subscript syntax to update Jupiter's moons to 78 and print the new value.
    solarSystem["Jupiter"] = 78
	println(solarSystem["Jupiter"])


}