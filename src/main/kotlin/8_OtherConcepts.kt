import kotlin.random.Random

fun main() {
    // typeCastingExample()
    // lateinitExample()
    lazyExample()
}

/*
   types casting- is , as
   is- checks whether an object is of a certain type
   !is- the opposite operator of 'is'
   as - converts an object in different type
   as?- null safe operator
* */

/*
    lateinit- allow us to create non-null, non initialised variable
    - need to initialise the variable before using it
    - accessing it before initialisation it throws exception
    - can be used only on var variables
    - .isInitialized to check initialisation
    - common use cases: i. dependency injection ii. unit testing
 */

/*
    lazy - lazy variables are variables that are initialised when needed
    - useful to save memory in case the variable is never accessed
    - performance optimisation
* */


fun typeCastingExample() {
    var string = "String"
    if (string is String) println("True")

    var car = getCar()
    if (car is BMW) println("BMW")
    if (car !is BMW) println("CAR")

    if (car is BMW) {
        (car as BMW).drive()
    }

    var mycar = car as? BMW
    mycar?.drive()

    var service = getNetworkService()
    (service as? FtpService)?.transferFile()

}

open class Car4 {}

class BMW : Car4() {
    fun drive() {
        println("drive")
    }
}

fun getCar(): Car4 = BMW()

open class NetworkService {}

class FtpService : NetworkService() {
    fun transferFile() {
        println("TransferFile")
    }
}

fun getNetworkService(): NetworkService {
    return if (Random.nextInt(100) % 2 == 0)
        NetworkService()
    else FtpService()

}

fun lateinitExample() {
    lateinit var service: FtpService
    service = FtpService()
    service.transferFile()
}


fun lazyExample() {
    val lazyString: String by lazy { "Lazy Test" }
    val lazyString1 by lazy { "Lazy Test" }

    if (Random.nextInt() % 2 == 0)
        println(lazyString)

    val list by lazy { generateList() }
    println(list)
}

fun generateList(): ArrayList<Int> {
    return arrayListOf(1, 2, 3, 4, 5)
}