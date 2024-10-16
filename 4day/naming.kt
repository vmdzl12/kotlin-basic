package com.example.clean

var ply: Polygon = Polygon()

fun calc(): Int {
    return 100
}

class Polygon {}

class Cust {
    var id: String = "C001"
    var name: String = "John"

    fun showData() {
        println("ID: $id, Name: $name")
    }
}

const val GRV = 9.80665

fun processCustList(customers: List<Cust>) {
    for (cust in customers) {
        println(cust.id)
    }
}

fun main() {
    var amt: Double = 200.0
    var idx: Int = 2

    val result = calc()

    val customer = Cust()

    val gravity = GRV

    val customers = listOf(customer)
    processCustList(customers)
}
