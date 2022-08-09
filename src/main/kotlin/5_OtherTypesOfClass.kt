/*
    - Data classes
    - Enum classes
    - Sealed classes
    - Nested classes
* */
fun main() {
    //dataClassExample()
    // enumExample()
    // sealedExample()
    innerClassExample()
}

/*
    Data classes - Commonly create classes just for storing data
    - primary constructor has at least one parameter
    - all primary constructor parameters need to be val or var
    - can have a body but not required
    - automatically generated class methods
    i. .equals or ==  : compares data not object reference
    ii. .toString() : prints out variable names and data
    iii. .copy() : creates a copy with only some data changed
*/
data class User(val name: String, val email: String)
class regularUser(val name: String, val email: String)

fun dataClassExample() {
    val user = User("sarah", "sarah@gmail.com")
    val user1 = User("sarah", "sarah@gmail.com")

    println(user) // output: User(name=sarah, email=sarah@gmail.com)
    val regularUserClass = regularUser("sarah", "sarah@gmail.com")
    val regularUserClass1 = regularUser("sarah", "sarah@gmail.com")
    println(regularUserClass) //output: regularUser@4a574795

    println(user == user1) // output: true
    println(regularUserClass == regularUserClass1) // output: false

    println(user.toString()) // output: User(name=sarah, email=sarah@gmail.com)
    println(regularUserClass.toString()) // output: regularUser@4a574795

    println(user.copy()) // output: User(name=sarah, email=sarah@gmail.com)

    var user3 = user.copy(name = "copy")
    println(user3.toString()) // output: User(name=copy, email=sarah@gmail.com)
}

/*
    enum (enumeration) classes - define a collection of constant
    - the constants defined are objects
    - the constants have properties
    - enum constants can be initialised
    - constants have properties like: name & ordinal
* */

enum class Color {
    RED,
    BLUE,
    GREEN
}

enum class Colors(val timesUsed: Int) {
    RED(10),
    BLUE(20),
    GREEN(30)
}

enum class ColorName(val timesUsed: Int, val values: String) {
    RED(10, "red"),
    BLUE(20, "blue"),
    GREEN(30, "green")
}

fun getColor(color: Color): Color {
    return when (color) {
        Color.RED -> Color.RED
        Color.BLUE -> Color.BLUE
        Color.GREEN -> Color.GREEN
    }
}

fun enumExample() {
    var color = Color.RED
    println(color) // output: RED
    println(getColor(color)) // output: RED

    println(Colors.RED.timesUsed) // output: 10
    println(Colors.RED.name) // output: RED
    println(Colors.RED.ordinal)// output: 0  (position)


    println(ColorName.RED.values)// output: red


}

/*
    sealed classes- define a restricted hierarchy
    - abstract by default so can not be initiated
    - useful in when expression
* */

fun sealedClassExample() {
    var plant = getPlant()
    when (plant) {
        is Fruit -> println("Fruit")
        is Vegetable -> println("Vegetable")
    }
}

abstract class Plant
sealed class Fruit : Plant()
sealed class Vegetable : Plant()
class Apple : Fruit()
class Potato : Vegetable()

fun getPlant(): Plant = Apple()


/*
    nested classes- a nested class is created inside another class
    - the inner class can access outer class variables and methods
    - this@X is the reference
    - outer class can create an instance of the inner class
* */

fun innerClassExample() {
    var car1 = Car1()
    car1.Engine().run()

    var car2 = Car2()
    car2.drive()
}

class Car1 {
    var speed = 100
    fun drive() {
        println("drive at speed $speed")
    }

    inner class Engine() {
        val rpm = 200
        fun run() {
            println("Engine is running rpm $rpm")
            this@Car1.speed = 200
            this@Car1.drive()
        }
    }
}

class Car2 {
    private val engine = Engine()
    var speed = 100
    fun drive() {
        engine.run()
        println("drive at speed $speed")
    }

    private inner class Engine() {
        val rpm = 200
        fun run() {
            println("Engine is running rpm $rpm")
            this@Car2.speed = 200
            //     this@Car2.drive() // otherwise create a loop
        }
    }
}