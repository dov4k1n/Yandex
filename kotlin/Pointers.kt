fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    val head = ListNode(0)
    var node = head    // "head" and "node" point to the same object
    var l1 = list1
    var l2 = list2
    while (l1 != null && l2 != null) {
        if (l1.`val` < l2.`val`) {
            node.next = l1    // changing property of an object, that "node" and "head" point to
            l1 = l1.next    // dereferencing l1 from list1's object
        } else {
            node.next = l2
            l2 = l2.next
        }
        node = node.next    // dereferencing "node", now it points not to the same object as head
    }
    node?.next = l1 ?: l2
    return head.next
}

fun reverseList(head: ListNode?): ListNode? {
    var curr = head
    var prev: ListNode? = null
    while (curr != null) {
        var next = curr.next
        curr.next = prev
        prev = curr
        curr = next
    }
    return prev
}

class ListNode(var num: Int) {
    var next: ListNode? = null
    
    override fun toString(): String {
        return "($num, $next)"
    }
}

fun main() {
    val dummy = ListNode(0)
    val node: ListNode? = dummy
    dummy.num = 1
    dummy.next = ListNode(2)
    println("dummy $dummy")   // dummy (1, (2, null))
    println("node $node")     // node (1, (2, null))
    println()
    
    node?.num = 10
    println("dummy $dummy")   // dummy (10, (2, null))
    println("node $node")     // node (10, (2, null))
}