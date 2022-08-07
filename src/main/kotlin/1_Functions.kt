fun main() {

    /* double(5)
     double(6, "message")*/

    //  println(calculateArea(5))
    /* val nameList = listOf("Romeo", "Ruma", "Tamanna", "Hena", "Wakar")
     for (name in nameList) {
         println(personalisedGreetings(name))
     }*/

    /* val products = hashMapOf(Pair("show", 29.99), Pair("Basket", 20.11))
     for (key in products) {
         println(addtax(key.value))
     }
     for (key in products.keys) {
         println(addtax(products[key]))
     }*/

    val input = readln() ?: ""
    val input1 = readLine() ?: ""
    println(input)
}

// optional parameter or parameters can have default values
fun double(number: Int, value: String = "test") {
    println("$number $value")
}

/*
fun calculateArea(radius: Int): Double {
    val pi = 3.1416
    return pi * radius * radius
}*/
// return shorthand- simplify codes & add more readability
fun calculateArea(radius: Int) = 3.1416 * radius * radius

fun personalisedGreetings(name: String): String {

    return when (name[0]) {
        'H' -> "Hello ${name}"
        'W' -> "Good ${name}"
        else -> "Hi ${name}"
    }

}

//fun addtax(value: Double) = value.times(1.2)
fun addtax(value: Double?) = value?.times(1.2)