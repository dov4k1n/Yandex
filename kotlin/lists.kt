fun main() {
    var myLovelyCats = listOf(
        "Мурзик",
        "Рыжик",
        "Барсик",
    )

    myLovelyCats = myLovelyCats + "Васька" - "Рыжик"

    println(myLovelyCats)

    val myLovelyCats2 = mutableListOf(
        "Мурзик",
        "Рыжик",
        "Барсик",
    )

    myLovelyCats2.add("Васька")
    myLovelyCats2.remove("Рыжик")

    println(myLovelyCats2)

    println(myLovelyCats2.get(1))
    println(myLovelyCats2[1])
    
    myLovelyCats2.forEach { println(it) }
    myLovelyCats2.forEach(::println)
    for (cat in myLovelyCats2) print(cat)

    val list0 = mutableListOf<Int>()
    list0.add(1)

    val list = listOf(1, 2, 3, 4, 5)
    println(list.any { it % 2 == 0 })
    println(list.any { it > 10 })
    println(list.all { it < 7 })
    
    val cats = listOf(
        Cat("Barsik", 5, 3),
        Cat("Murzik", 9, 5)
    )
    println(cats.all { it.age < 11 })
    println(list.none { it > 6 })
}

data class Cat(var name: String, var age: Int, var weight: Int) {
    }