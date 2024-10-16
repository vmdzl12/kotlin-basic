package com.example.myapplication

enum class Breed {
    JINDO, POODLE, BULLDOG, SHIBA
}

data class DogInfo(val name: String, val age: Int)

class Dog(val info: DogInfo, val breed: Breed) {
    fun sound() {
        println("멍멍")
    }

    fun showInfo() {
        println("Name: ${info.name}, Age: ${info.age}, Breed: $breed")
    }
}

fun main() {
    val poodleInfo = DogInfo("Charlie", 3)
    val poodle = Dog(poodleInfo, Breed.POODLE)

    poodle.sound()
    // 출력: 멍멍
    poodle.showInfo()
    // 출력: Name: Charlie, Age: 3, Breed: POODLE
}
