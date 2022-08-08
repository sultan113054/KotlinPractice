import kotlin.random.Random

// standard functions- functions that u can apply on objects that will take lamda expression and give u some result
/*
 also called scope function-
- execute code in the context of an object
- creates temporary scope while the code is executed
- In the scope we can access original object
- 5 scope functions - let,run,with,apply,also
- 2 check functions- takeIf, takeUnless
*/


fun main() {
    //  letExample()
    // withExample()
    // runExample()
    //applyExample()
    //alsoExample()
    // takeIfExample()
     takeUnlessExample()
}


/*
 let- allows to run code on a object
 - we can access the result as a lamda argument it by default
 - if the block of code contains a single function call, we can use method reference ::
 - a common use case is to use let to filter for non-null variables
 */
fun letExample() {
    /*   val list = listOf("abc", "df", "ghiss")
       list.map { it.length }
           .filter { it > 2 }
   //        .let {
   //            println(it)
   //            println(it.size)
   //        }
   //        .let { filteredList ->
   //            println(filteredList)
   //            println(filteredList.size)
   //        }
           .let(::println)*/

    /*  var name = readLine()
      name?.let { println(it) }*/

    var animal = arrayListOf<String?>()
    for (i in 1..3) {
        val input = readLine()
        input?.let {
            if (it == "")
                animal.add(null)
            else animal.add(it)
        }
    }
    animal.forEach(::println)
    animal.forEach { it?.let(::println) }

}

/*
   with -perform a block of code on an object
   - The context is available as 'this' (the 'this' keyword can be omitted)
   - can access variables & methods
   typical use case
   - perform some initialization on an object
   - perform a sequence of actions on an object


*/

fun withExample() {
    with(Car()) {
        speed = 100
        drive()
    }
}

class Car {
    var speed = 50
    fun drive() {
        println(speed)
    }
}

/*
    run- same as with but invokes an extension function
    - useful when we need a lamda that returns a result
    - can be used to limit the scope of variables
  */

fun runExample() {
    var car = Car().run {
        speed = 100
        drive()
        this
    }
    println(car)
    run {
        var car = Car()
        car.speed = 200
        car.drive()
        car
    }
    run {
        var car = Car()
        car.speed = 200
        car.drive()
    }
}

/*
    apply- can be used to apply some functionality and returns a result
    -returns the initial object
    -common use case is applying configuration to an object creation
*/

fun applyExample() {
    var car = Car().apply {
        speed = 500
        drive()
    }

    println(car)
}

/*
    also- used for performing some additional actions on an object
    - common use case is adding some actions that don't affect the object such as logging or debugging information
    - removing an also block should not affect the execution of program

* */

fun alsoExample() {
    Car().apply {
        speed = 1000
        drive()
    }.also {
        println("Log ${it.speed}")
    }
}

/*
    takeIf- returns the object if the predicate values to true otherwise returns null

*/

fun takeIfExample() {
    val number = Random.nextInt(100)
    val evenOrNull = number.takeIf { it % 2 == 0 }
    println("$number $evenOrNull")

    val list = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
    var listEven = ArrayList<Int>()
    for (item in list) {
        item.takeIf { it % 2 == 0 }?.let { listEven.add(it) }
    }
    println(listEven)
}
/*
    takeUnless- returns the object if the predicate values to false otherwise returns null

*/

fun takeUnlessExample() {
    val number = Random.nextInt(100)
    val evenOrNull = number.takeUnless { it % 2 == 0 }
    println("$number $evenOrNull")
    val list = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
    var listOdd = ArrayList<Int>()
    for (item in list) {
        item.takeUnless { it % 2 == 0 }?.let { listOdd.add(it) }
    }
    println(listOdd)
}
