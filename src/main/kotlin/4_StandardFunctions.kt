fun main() {
letExample()
}
// standard functions- functions that u can apply on objects that will take lamda expression and give u some result
/*
 also called scope function-
- execute code in the context of an object
- creates temporary scope while the code is executed
- In the scope we can access original object
- 5 scope functions - let,run,with,apply,also
- 2 check functions- takeIf, takeUnless
*/

/*
 let- allows to run code on a object
 - we can access the result as a lamda argument it by default
 */
fun letExample() {
    val list = listOf("abc", "df", "ghiss")
    list.map { it.length }
        .filter { it > 2 }
        .let {
            println(it)
            println(it.size)
        }

}