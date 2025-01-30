* Changing object's *variables* inside function is **allowed**
* Changing *objects and primitives* inside function is **not allowed**

```kotlin
fun main() {
    val foo = Foo(5)
    foo.property_var = 6
    change(foo)
    println(foo) // prints "10 12"
    
    var a = 1290
    change(a)
    println(a)
}

class Foo(var constructor_var: Int) {
    var property_var: Int = 0
    
    override fun toString(): String {
        return "$constructor_var $property_var"
    }
}

fun change(b: Foo) {
    b.constructor_var = 10  // allowed
    b.property_var = 12     // allowed
//  b = Foo(0)              // compile error: 'val' cannot be reassigned.
}

fun change(a: Int) {
//  a += 10                 // compile error: 'val' cannot be reassigned. 
}

```