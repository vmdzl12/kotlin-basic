package com.example.mvvm

data class Car(val name: String, var speed: Int = 0)

fun increaseSpeed(car: Car) {
    while (car.speed < 50) {
        Thread.sleep(1000)  // 1초 대기
        car.speed += 10
        println("${car.name}의 현재 속도: ${car.speed} km/h")
    }
    println("${car.name}가 최대 속도에 도달했습니다!")
}

fun main() {
    val myCar = Car("MyCar")
    println("${myCar.name}의 속도 증가를 시작합니다.")

    // 속도 증가 함수 호출
    increaseSpeed(myCar)
}
