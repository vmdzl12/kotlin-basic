class Greeter {
    private val greetingService = EnglishGreetingService()

    fun greet(name: String) {
        greetingService.greet(name)
    }
}

class EnglishGreetingService {
    fun greet(name: String) {
        println("Hello, $name")
    }
}

fun main() {
    val greeter = Greeter()
    greeter.greet("John")
}
