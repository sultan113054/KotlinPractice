fun main() {
    var lamda: (String) -> Unit = { name: String -> println(name) }
/*    //way 1
     sayHello(arrayListOf("a", "b", "c"), { name: String -> println(name) })
    //way 2
     sayHello(arrayListOf("a", "b", "c")) { name: String -> println(name) }*/

/*    //way 1
    println(update(arrayListOf(11, 12, 13, 14, 8,56)) { number: Int -> number / 10 })
   //way 2
    println(update(arrayListOf(11, 12, 13, 14, 8,56)) { number -> number / 10 })*/

    /*   val list=ArrayList<String>()
       list.add("a")
       list.add("b")
       println(list)*/

    // common higher order function

    var list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    // list.forEach { value -> println(value) }
    // list.forEach { println(it) }
    // list.forEach({ println(it) })
    //  list.filter { item -> item < 5 }// list.filter {  item < 5 }
    //     .forEach { println(it) }

    var listString = listOf("abcd", "de", "fghi")

    // println(listString.map { it.length }) // returns new list
    // println(listString.sortedBy { it.length }) // returns sorted by length of string
    // println(listString.maxByOrNull { it.length }) // returns max length  string
    // println(listString.minByOrNull { it.length }) // returns min length  string

    // print only double digit integers
    val number = listOf(1, 2, 3, 57, 5679)
    // println(number.filter { it in 10..99 })

    //sort last letter of name
    val strings = listOf("abx", "abc", "def", "ghu")
    // println(strings.sortedBy { it[it.length - 1] })

    //3 digit integers list to print biggest middle digit integer
    val list1 = listOf(123, 1, 89)
    // println(list1.maxByOrNull { it / 10 % 10 })
    // println(list1.maxByOrNull { it.toString()[1] })
    val newList = list1.map {
        if (it % 2 == 0)
            it / 2
        else it * 2
    }.filter { it < 25 }
    println(newList)

}

// Lamda functions- functions that don't have a name. we can call anonymous function
// A Lamda ia an anonymous function (has no name)
// A Lamda function can be assign to a variable
// this variable can be passed as a parameter to a new function Higher order functions
// unit-> return type void, doesn't return anything

/*
fun printMessage(name: String) {
    println(name)
}
above function lamda:
{name:String-> println(name)}
var myLamda={name:String-> println(name)}
*/

// Higher order function takes a function as a parameter

fun sayHello(names: ArrayList<String>, doSomething: (String) -> Unit) {
    for (name in names) {
        doSomething(name)
    }
}

fun update(numbers: ArrayList<Int>, lmd: (Int) -> Int): ArrayList<Int> {
    for (i in 0..numbers.size - 1) {
        if (numbers[i] % 2 == 0) {
            numbers[i] = lmd(numbers[i])
        }
    }

    return numbers
}