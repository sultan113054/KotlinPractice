fun main() {
    //fun1(listOf("a","b"))
    // mapPrint(mapOf(Pair("a", 10)))
 //   sayHello("sarah", "sabah", "")
    animals()

}

// function overloading- different types or numbers of parameter

fun fun1(number: Int) = println("Int")
fun fun1(number: Double) = println("Double")
fun fun1(number: Double, number1: Int) = println("Double")

fun fun1(list: Collection<String>) {
    for (item in list)
        println(item)
}

fun mapPrint(items: Map<String, Int>) {
    for (item in items.keys)
        println("${items[item]} $item")
}

// vararg- variable number of parameters (arguments)

fun sayHello(vararg names: String) {
    for (item in names)
        println(item)
}

// local functions- functions inside a function
fun animals() {
    fun listanimal(name: String) {
        println(name)
    }

    val items = arrayListOf("a", "b")
    for (item in items)
        listanimal(item)
}