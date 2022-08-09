/*
*   Extensions- allow us to extend a class that we don't own or can't modify
    - without need to inherit from that class
    - Add functionality that is available in the context of our program only
    - added code can be called in the usual way by declaring objects of that class and invoking methods
    - extensions can extend i. functions ii. properties iii. companion object
* */

fun main() {
    // functionExample()
    // propertiesExample()
    companionExample()
}

/*
    Extension functions- can add functions to a class that we don't own or can't modify
    - can access the object using 'this' reference
    - the original class is not actually modified
    - the new functions are not actually inserted in the class rather it's a shortcut to make the function available
    using the usual object.function notation
* */

fun functionExample() {
    val name = "Sarah"
    println(name.slim())// output: ara
    println(4.slim())// output: this is Int
    println(1.5F.slim())// output: this is float
    var list = arrayListOf(1, 2, 3, 4, 5)
    println(list.arraySize()) // output: Size 5
}

fun String.slim() = this.substring(1, length - 1)
fun Int.slim() = "this is Int"
fun Float.slim() = "this is float"
fun ArrayList<Int>.arraySize() = "Size $size"

/*
    Extension properties- can add properties to classes in a similar way to functions
    - they can't be local i.e. inside a class or function
    - can't update an extension property can only use values (Val), not variables (var)
    - this property is not actually inserted into the class
    - the extension properties are a shortcut for the '.' notation
    - initializations are not allowed val String.betterLength=7 // error

* */

fun propertiesExample() {
    var name = "Sarah"
    println(name.limitLenght) //output:200
}

val String.limitLenght: Int
    get() = 200


/*
    companion object extensions - if a class has companion object defined, we can extend it with functions and properties
    - if not, we can't add a companion object
* */

fun companionExample() {
    Book.printMe()
    String.getClassType()
    Double.printClassName()
}

class Book {
    companion object {}
}

fun Book.Companion.printMe() {
    println("print")
}

fun String.Companion.getClassType() = println("This is a String class")
fun Double.Companion.printClassName() = println("This is a Double class")