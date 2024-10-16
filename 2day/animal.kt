package com.example.myapplication

abstract class Animal {
    abstract fun sound()
}

class Dog : Animal() {
    override fun sound() {
        println("멍멍")
    }
}

class Cat : Animal() {
    override fun sound() {
        println("야옹")
    }
}

fun main() {
    val dog = Dog()
    val cat = Cat()

    dog.sound()  // 출력: 멍멍
    cat.sound()  // 출력: 야옹
}
