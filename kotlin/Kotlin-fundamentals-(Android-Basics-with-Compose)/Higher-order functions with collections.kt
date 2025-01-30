// [1] forEach() to loop over each element in a collection.
// [2] map() to format the items in a collection, often as a collection of another data type.
// [3] filter() to generate a subset of a collection.
// [4] groupBy() to split a collection based on a function's return value.
// [5] fold() to turn a collection into a single value.
// [6] sortedBy() to sort a collection by a specified property.

class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double
)

val cookies = listOf(
    Cookie(
        name = "Chocolate Chip",
        softBaked = false,
        hasFilling = false,
        price = 1.69
    ),
    Cookie(
        name = "Banana Walnut", 
        softBaked = true, 
        hasFilling = false, 
        price = 1.49
    ),
    Cookie(
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price = 1.59
    ),
    Cookie(
        name = "Chocolate Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie(
        name = "Snickerdoodle",
        softBaked = true,
        hasFilling = false,
        price = 1.39
    ),
    Cookie(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)


// [2] The map() function lets you transform a collection into a new collection with the same number of elements.
val fullMenu = cookies.map {
    "${it.name} - $${it.price}"
}


// [3] The filter() function lets you create a subset of a collection.
val softBakedMenu = cookies.filter {
	it.softBaked
}


// [4] The groupBy() function can be used to turn a list into a map, based on a function.
val groupedMenu = cookies.groupBy { it.softBaked }
val softBakedMenuGrouped = groupedMenu[true] ?: emptyList()
val crunchyMenu = groupedMenu[false] ?: emptyList()
// Note: If you only need to split a list in two, an alternative is the partition() function.


// [5] The fold() function is used to generate a single value from a collection.
// 
// The fold() function takes two parameters:
// 
// 1) An initial value. The data type is inferred when calling the function 
// (that is, an initial value of 0 is inferred to be an Int, 0.0 as Double).
// 
// 2) A lambda expression that returns a value with the same type as the initial value.
// 
// The lambda expression additionally has two parameters:
// 
// 1) The first is known as the accumulator. It has the same data type as the initial value.
// Think of this as a running total. Each time the lambda expression is called, 
// the accumulator is equal to the return value from the previous time the lambda was called.
// 
// 2) The second is the same type as each element in the collection.
val totalPrice = cookies.fold(0.0) {total, cookie ->
    total + cookie.price
}
// Note: fold() is sometimes called reduce().
// The fold() function in Kotlin works the same as the reduce() function 
// found in JavaScript, Swift, Python, etc. Note that Kotlin also has its own 
// function called reduce(), where the accumulator starts with the first element 
// in the collection, rather than an initial value passed as an argument.
// 
// Note: Kotlin collections also have a sum() function for numeric types, as well as a higher-order sumOf() function.


// [6]
val alphabeticalMenu = cookies.sortedBy {
    it.name
}
// Note: Kotlin collections also have a sort() function if the data type has a natural sort order.

fun main() {
    // [1] forEach(action: (T) -> Unit)
    cookies.forEach {
        println("Menu item: ${it.name}")
    }
    println()
    
    println("Full menu:")
	fullMenu.forEach {
    	println(it)
	}
    println()
    
    println("Soft cookies:")
	softBakedMenu.forEach {
    	println("${it.name} - $${it.price}")
	}
    println()
    
    println("Crunchy cookies:")
    crunchyMenu.forEach {
        println("${it.name} - $${it.price}")
    }
    println()
    
    println("Total price: $${totalPrice}")
    println()
    
    println("Alphabetical menu:")
    alphabeticalMenu.forEach {
        println(it.name)
    }
    println()
}