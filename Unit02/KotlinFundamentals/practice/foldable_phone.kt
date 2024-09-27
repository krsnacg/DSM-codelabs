open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }
    
    fun switchOff() {
        isScreenLightOn = false
    }
    
    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(var isPhoneFolded: Boolean = false) :
	Phone() {
    override fun switchOn() {
        if (!isPhoneFolded) {
        	isScreenLightOn = true
            println("Phone switched on.")
        }
        else {
            println("Couldn't switch on. Phone is currently folded.")
        }
    }
    
    fun foldPhone() {
        isScreenLightOn = false
        isPhoneFolded = true
    }
    
    fun unfoldPhone() {
        isPhoneFolded = false
    }
    
}
    
fun main() {
    val foldablePhone = FoldablePhone()
    
    foldablePhone.switchOn()
    foldablePhone.foldPhone()
    foldablePhone.switchOn()
}
    