/*
    Generics- a class can have type parameters
    - the type can be used by variables and methods
    - useful when a class can handle multiple types of parameters
    - we can have multiple generics, separated by comma
    type parameters - we can restrict the type of generic parameters
    - for multiple constraints we can separate them by comma
* */

fun main() {
    var box = Box<String>()
    // box.display("Test")

    var car = Box<Car3>()
    // car.display(Car3())

    var newBox = NewBox<Int, Float>()
    // newBox.display(12, 12.09F)

    var info1 = Info<String>()
    // info1.getLength("test")
    var info2 = Info<Double>()
    // info2.getLength(12.223)

    var chef1 = Chef<Jackfruit>()
    chef1.cook(Jackfruit())
    var chef2 = Chef<Banana>()
    chef2.cook(Banana())
}

class Box<T> {
    fun display(item: T) {
        println(item)
    }
}

class Car3 {}
class NewBox<T, U> {
    fun display(item: T, item2: U) {
        println(item)
        println(item2)
    }
}

class Info<T> {
    fun getLength(item: T) {
        println(item.toString().length)
    }
}

abstract class Fruits {
    abstract fun peel()
}

class Jackfruit : Fruits() {
    override fun peel() {
        println("Jackfruit")
    }
}

class Banana : Fruits() {
    override fun peel() {
        println("Banana")
    }
}

class Chef<T : Fruits> {
    fun cook(item: T) {
        item.peel()
    }
}