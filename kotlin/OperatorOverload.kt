// source: https://kotlinlang.org/docs/operator-overloading.html

class ListNode(var num: Int) {
    var next: ListNode? = null
	
    operator fun compareTo(other: ListNode): Int {
        return this.num.compareTo(other.num)
    }

    // for println() function
    override fun toString(): String {
        return "($num)"
         // return "($num, $next)" // will throw java.lang.StackOverflowError when next.next == this
    }
}

// also works:
// 
// operator fun ListNode.compareTo(other: ListNode): Int {
//     if (this.num < other.num) return -1
//     if (this.num > other.num) return 1
//     if (this.num <= other.num) return 0
//     if (this.num >= other.num) return 0
//     else return -1
// }

fun main() {
    val a = ListNode(5)
    val b = ListNode(10)
    a.next = b
    //b.next = a
    println("$a is < than $b ? ${a < b}")
    println("$a is > than $b ? ${a > b}")
    println("$a is <= than $b ? ${a <= b}")
    println("$a is >= than $b ? ${a >= b}")
    println()
    
    val c = ListNode(11)
    val d = ListNode(11)
    println("$c is < than $d ? ${c < d}")
    println("$c is > than $d ? ${c > d}")
    println("$c is <= than $d ? ${c <= d}")
    println("$c is >= than $d ? ${c >= d}")
    println()
    
    val nc = ListNode(-11)
    val nd = ListNode(-11)
    println("$nc is < than $nd ? ${nc < nd}")
    println("$nc is > than $nd ? ${nc > nd}")
    println("$nc is <= than $nd ? ${nc <= nd}")
    println("$nc is >= than $nd ? ${nc >= nd}")
    println()
    
    println("$nc is < than $d ? ${nc < d}")
    println("$nc is > than $d ? ${nc > d}")
    println("$nc is <= than $d ? ${nc <= d}")
    println("$nc is >= than $d ? ${nc >= d}")
    println()
    
    println("$c is < than $nd ? ${c < nd}")
    println("$c is > than $nd ? ${c > nd}")
    println("$c is <= than $nd ? ${c <= nd}")
    println("$c is >= than $nd ? ${c >= nd}")
}