
class Song(val title: String, val artist: String, val yearPublished: Int, var playCount: Int) {

    var isPopular: String = when(playCount) {
        in 0..1000 -> "unpopular"
        else -> "popular"
    }
    
    fun printDescription() {
        println("[$title], performed by [$artist], was released in [$yearPublished].")
    }

    fun printPopularity() {
        println("The song is $isPopular")
    }

}

​
fun main() {
    val song = Song("In the end","Linkin Park", 2005, 120000)
    song.printDescription()
    song.printPopularity()
}

