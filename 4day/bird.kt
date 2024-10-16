package com.example.clean

// 새의 공통 특성을 가진 추상 클래스
open class Bird {
    open fun fly() {
        println("The bird is flying")
    }

    open fun eat() {}
    open fun run() {}
    open fun tweet() {}
}

// 날 수 있는 새
class Sparrow : Bird() {
    override fun fly() {
        println("The sparrow flaps its wings and flies.")
    }

    override fun eat() {
        println("The sparrow eats seeds.")
    }

    override fun run() {
        println("The sparrow hops on the ground.")
    }

    override fun tweet() {
        println("The sparrow tweets melodiously.")
    }
}

// 날 수 없는 새
class Penguin : Bird() {
    override fun fly() {
        throw UnsupportedOperationException("Penguins can't fly")
    }

    override fun eat() {
        println("The penguin catches fish in the ocean.")
    }

    override fun run() {
        println("The penguin waddles on the ice.")
    }

    override fun tweet() {
        println("The penguin honks.")
    }
}

fun main() {
    val sparrow = Sparrow()
    sparrow.eat()

    val penguin = Penguin()
    penguin.fly()
}
