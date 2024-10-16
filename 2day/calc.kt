package com.example.myapplication

fun Int.add(num: Int): Int = this + num
fun Int.sub(num: Int): Int = this - num
fun Int.mul(num: Int): Int = this * num
fun Int.div(num: Int): Int = this / num


fun main() {
    val a = 10
    val b = 5

    println("Add: ${a.add(b)}")
}
