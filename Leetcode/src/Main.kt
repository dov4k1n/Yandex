





// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (root == null || p == null || q == null) return null

    var cur = root
    while (cur != null) {
        if (p.`val` < cur.`val` && q.`val` < cur.`val`) {
            cur = cur.left
        } else if (p.`val` > cur.`val` && q.`val` > cur.`val`) {
            cur = cur.right
        } else {
            return cur
        }
    }
    return null
}





// https://leetcode.com/problems/subtree-of-another-tree/
fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
    val q = ArrayDeque<TreeNode?>()
    q.addLast(root)
    while (q.isNotEmpty()) {
        val node = q.removeFirst()
        if (node?.`val` == subRoot?.`val` &&
            isSameTree(node, subRoot)) {
            return true
        } else {
            if (node?.left != null) q.addLast(node.left)
            if (node?.right != null) q.addLast(node.right)
        }
    }
    return false
}





// https://leetcode.com/problems/same-tree/
fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null) return true
    if (p != null && q != null && p.`val` == q.`val`) {
        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right)
    }
    return false
}





// https://leetcode.com/problems/balanced-binary-tree/
private var isBalanced = true

fun isBalanced(root: TreeNode?): Boolean {
    dfs(root)
    return isBalanced
}

fun abs(x: Int): Int = if (x >= 0) x else (-1) * x

private fun dfs2(root: TreeNode?): Int {
    if (root == null) return 0

    val lh = dfs2(root.left)
    val rh = dfs2(root.right)

    if (abs(lh - rh) > 1) isBalanced = false

    return 1 + maxOf(lh, rh)
}





// https://leetcode.com/problems/diameter-of-binary-tree/
private var diameter = 0

fun diameterOfBinaryTree(root: TreeNode?): Int {
    // for each node calculate its left and right subtree heights
    // longest path that pass through that node is the sum of those heights
    // the diameter of the whole tree is the max of those longest paths
    dfs(root)
    return diameter
}

private fun dfs(root: TreeNode?): Int {
    if (root == null) return 0

    val leftHeight = dfs(root.left)
    val rightHeight = dfs(root.right)
    diameter = maxOf(diameter, leftHeight + rightHeight)

    return 1 + maxOf(leftHeight, rightHeight)
}





// https://leetcode.com/problems/maximum-depth-of-binary-tree/
fun maxDepth(root: TreeNode?): Int {
    if (root == null) return 0
    return 1 + maxOf(maxDepth(root.left), maxDepth(root.right))
}





// https://leetcode.com/problems/invert-binary-tree/
fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return null

    val tmp = root.left
    root.left = root.right
    root.right = tmp

    invertTree(root.left)
    invertTree(root.right)

    return root
}
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}





// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    // 1 2 3 4 5 6 7   8   9 10 11 12 13
    // 1 2 3 4 5 6 7   8   9 10 11 12 13
    // calculate size
    // step from the begin size-n times
    // remove the node
    // var sz = 0
    // var node = head
    // while (node != null) {
    //     sz++
    //     node = node?.next
    // }

    // if (sz == n) return head?.next
    // node = head
    // repeat (sz-n-1) {
    //     node = node?.next
    // }
    // node?.next = node?.next?.next
    // return head

    // step n times with one iterator
    // step with second iterator while first reaches the end
    // remove the node
    var first = head
    repeat (n) {
        first = first?.next
    }

    val prehead = ListNode(0)
    prehead.next = head
    var second: ListNode? = prehead

    while (first != null) {
        first = first?.next
        second = second?.next
    }
    second?.next = second?.next?.next

    return prehead.next
}





// https://leetcode.com/problems/reorder-list/
fun reorderList(head: ListNode?): Unit {
    // initial:
    // 1 > 2 > 3 > 4 > 5 > ... > n

    // result:
    // 1 > n > 2 > n-1 > 3 > n-2 > ...

    // step -1 binding:
    // 1 > 2 > 3 > ... > n/2
    // n > n-1 > n-2 > ... > n/2 + 1

    // step -2 reversing 2nd half order:
    // 1 > 2 > 3 > ... > n/2
    // n/2 + 1 > ... > n-2 > n-1 > n

    // step -3 splitting in half

    // step -4 finding the middle (with fast & slow pointers approach)

    var slow = head
    var fast = head?.next
    while (fast != null) { // finding the middle
        slow = slow?.next
        fast = fast.next?.next
        // fast pointer is twice faster than slow pointer
        // so when slow reaches the middle
        // fast reaches the end
        // and vice versa
    }

    var shalf = slow
    var curr = shalf
    var prev: ListNode? = null
    while (curr != null) { // reversing 2nd half order
        val next = curr.next
        curr.next = prev
        prev = curr
        curr = next
    }

    shalf = prev
    var fhalf = head
    while (shalf != null || fhalf != null) { // binding
        val fnext = fhalf?.next
        val snext = shalf?.next
        fhalf?.next = shalf
        shalf?.next = fnext
        fhalf = fnext
        shalf = snext
    }
}





// https://leetcode.com/problems/linked-list-cycle/
fun hasCycle(head: ListNode?): Boolean {
    var slow = head
    var fast = head
    while (true) {
        slow = slow?.next
        fast = fast?.next?.next
        if (fast == null) return false
        if (slow == fast) return true
    }
    return false
}





// https://leetcode.com/problems/merge-two-sorted-lists/
fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    val head = ListNode(0)
    var node = head
    var l1 = list1
    var l2 = list2
    while (l1 != null && l2 != null) {
        if (l1.`val` < l2.`val`) {
            node.next = l1
            l1 = l1.next
        } else {
            node.next = l2
            l2 = l2.next
        }
        node = node.next!!
    }
    node.next = l1 ?: l2
    return head.next
}





// https://leetcode.com/problems/reverse-linked-list/
fun reverseList(head: ListNode?): ListNode? {
    var curr = head
    var prev: ListNode? = null
    while (curr != null) {
        val next = curr.next
        curr.next = prev
        prev = curr
        curr = next
    }
    return prev
}
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}





// https://leetcode.com/problems/longest-repeating-character-replacement/
fun characterReplacement(s: String, k: Int): Int {
    val count = HashMap<Char, Int>()
    var maxF = 0
    var res = 0
    var l = 0
    for (r in 0..s.length-1) {
        count[s[r]] = 1 + count.getOrDefault(s[r], 0)
        maxF = maxOf(maxF, count[s[r]]!!)
        while (r-l+1 - maxF > k) {
            count[s[l]] = count[s[l]]!! - 1
            l++
        }
        res = maxOf(res, r-l+1)
    }
    return res
}





// https://leetcode.com/problems/longest-substring-without-repeating-characters/
fun lengthOfLongestSubstring(s: String): Int {
    var ans = 0
    val encountered = HashMap<Char, Boolean>()
    var l = 0
    var r = 0
    fun maxOf(a: Int, b: Int): Int = if (a < b) b else a
    while (r < s.length) {
        if (encountered[s[r]] == null) {
            ans = maxOf(r - l + 1, ans)
        } else {
            while (encountered[s[r]] != null) {
                encountered.remove(s[l])
                l++
            }
        }
        encountered[s[r]] = true
        r++
    }
    return ans
}





// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
fun maxProfit(prices: IntArray): Int {
    // while not encountered
    // lower price to buy
    // calculate profits and save maximum
    // else repeat with new buying price, but lower

    fun maxOf(a: Int, b: Int): Int = if (a < b) b else a

    var l = 0
    var r = 1
    var maxP = 0
    while (r < prices.size) {
        if (prices[l] < prices[r]) {
            val profit = prices[r] - prices[l]
            maxP = maxOf(profit, maxP)
        } else {
            l = r
        }
        r++
    }
    return maxP
}





// https://leetcode.com/problems/koko-eating-bananas/
fun minEatingSpeed(piles: IntArray, h: Int): Int {
    // it takes ceil(x/k) hours to eat one pile
    // need to minimize k
    // and eat all piles within h hours
    //
    // k is in 1..max(piles)
    // do binary search in that range
    //
    // algorithm would take O(nlogm) time and O(1) space
    // where n == piles.size, m == max(piles)

    var max = piles[0]
    piles.forEach { if (it > max) max = it }

    fun ceil(x: Double): Long {
        if (x.toInt() < x)
            return x.toLong() + 1
        return x.toLong()
    }

    var l = 1
    var r = max
    var k = max
    while (l <= r) {
        val m = (l + r) / 2
        var time: Long = 0
        piles.forEach { time += ceil(it.toDouble() / m) }
        if (time <= h) {
            if (m < k) k = m
            r = m - 1 // maybe can eat less
            continue
        } else {
            l = m + 1 // need to eat more
            continue
        }
    }
    return k
}





// https://leetcode.com/problems/search-a-2d-matrix/
fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    // binary search for row
    // then binary search for column
    var t = 0
    var b = matrix.size - 1
    var mRow = (t + b) / 2

    while (t <= b) {
        when {
            matrix[mRow][0] == target -> return true
            matrix[mRow][0] < target -> t = mRow + 1
            matrix[mRow][0] > target -> b = mRow - 1
        }
        mRow = (t + b) / 2
    }

    var l = 0
    var r = matrix[mRow].size - 1

    while (l <= r) {
        val mCol = (l + r) / 2
        when {
            matrix[mRow][mCol] == target -> return true
            matrix[mRow][mCol] < target -> l = mCol + 1
            matrix[mRow][mCol] > target -> r = mCol - 1
        }
    }

    return false
}




// https://leetcode.com/problems/binary-search/
fun search(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1
    while (left <= right) {
        val mid = (left + right) / 2
        if (nums[mid] == target) {
            return mid
        } else if (nums[mid] < target) {
            left = mid + 1
            continue
        } else if (nums[mid] > target) {
            right = mid - 1
            continue
        }
    }
    return -1
}





// https://leetcode.com/problems/evaluate-reverse-polish-notation/
fun evalRPN(tokens: Array<String>): Int {
    val stack = ArrayDeque<Int>()
    var a: Int
    var b: Int
    for (token in tokens) {
        if (token == "+") {
            a = stack.removeLast()
            b = stack.removeLast()
            stack.addLast(b + a)
        } else if (token == "-") {
            a = stack.removeLast()
            b = stack.removeLast()
            stack.addLast(b - a)
        } else if (token == "*") {
            a = stack.removeLast()
            b = stack.removeLast()
            stack.addLast(b * a)
        } else if (token == "/") {
            a = stack.removeLast()
            b = stack.removeLast()
            stack.addLast(b / a)
        } else {
            stack.addLast(token.toInt())
        }
    }
    return stack.removeLast()
}





// https://leetcode.com/problems/min-stack/
class MinStack() {
    class ListNode(var value: Int) {
        var next: ListNode? = null
        var min: Int = value
    }

    private var top: ListNode? = null

    fun push(`val`: Int) {
        if (top == null) {
            top = ListNode(`val`)
        } else {
            val new = ListNode(`val`)
            val topCopy = top
            if (`val` < topCopy!!.min) {
                new.min = `val`
            } else {
                new.min = topCopy.min
            }
            new.next = topCopy
            top = new
        }
    }

    fun pop() {
        top = top?.next
    }

    fun top(): Int {
        return top!!.value
    }

    fun getMin(): Int {
        return top!!.min
    }
}





// https://leetcode.com/problems/valid-parentheses/description/
fun isValid(s: String): Boolean {
    val closeToOpen = hashMapOf(
        ')' to '(',
        ']' to '[',
        '}' to '{'
    )
    val stack = ArrayDeque<Char>()
    s.forEach {
        if (it == '(' ||
            it == '[' ||
            it == '{') {
            stack.addLast(it)
        } else if (closeToOpen[it] != stack.removeLastOrNull()) {
            return false
        }
    }
    if (stack.size != 0) return false
    return true
}





// https://leetcode.com/problems/3sum/description/
fun threeSum(nums: IntArray): List<List<Int>> {
    // O(N^3) time, O(N) space solution:
    //
    // brute force
    // ans = hashset of lists
    // sort input to exclude adding duplicates
    // for i in 0..nums.size-3
    //   for j in i..nums.size-2
    //     for k in j..nums.size-1
    //       if nums[i] + nums[j] + num[k] == target
    //         add to ans

//        val sorted = nums.sorted()
//        val ans = HashSet<List<Int>>()
//        for (i in 0..sorted.size-3) {
//            for (j in i+1..sorted.size-2) {
//                for (k in j+1..sorted.size-1) {
//                    if (sorted[i] + sorted[j] + sorted[k] == 0) {
//                        ans.add(listOf(sorted[i], sorted[j], sorted[k]))
//                    }
//                }
//            }
//        }
//        return ans.toList()



    // O(N^2) time, O(N) space solution:
    //
    // iterate through array,
    //   for each search two indices
    //   that sum up to target - it
    //   it would take also O(N) (two sum problem)

    val sorted = nums.sorted()
    val ans = mutableListOf<List<Int>>()
    for (i in 0..sorted.size-3) {
        if (sorted[i] > 0) break // all negatives processed (micro opt)
        if (i > 0 && sorted[i] == sorted[i - 1]) continue // skipping duplicates (micro opt)

        val target = (-1) * sorted[i]
        var left = i + 1
        var right = sorted.size - 1
        while (left < right) {
            val sum = sorted[left] + sorted[right]
            if (sum == target) {
                ans.add(listOf(sorted[i], sorted[left], sorted[right]))
                left++
                right--
                while (left < right &&
                    sorted[left] == sorted[left - 1]) {
                    left++
                }
            } else if (sum > target) {
                right--
                continue
            } else if (sum < target) {
                left++
            }
        }
    }
    return ans
}





// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
fun twoSum2(numbers: IntArray, target: Int): IntArray {
    // O(N) time, O(1) space solution:
    //
    // two pointers - left, right
    // pointing to the begin and end
    // if left + right equals target
    //   return (left, right)
    // if left + right is less than target
    //   increase left
    // if left + right is greater than target
    //   decrease right
    // else return empty array

    var left = 0
    var right = numbers.size - 1

    while (left < right) {
        val sum = numbers[left] + numbers[right]

        if (sum == target) {
            return intArrayOf(left + 1, right + 1)
        } else if (sum < target) {
            left++
            continue
        } else if (sum > target) {
            right--
            continue
        }
    }

    return intArrayOf()
}





// https://leetcode.com/problems/valid-palindrome/
fun isPalindrome(s: String): Boolean {
    // O(N) time, O(N) space solution:
    //
    // for i in 0..s.len/2 - 1
    //   if (s[i] != s[len-1 - i])
    //     return false
    // return true

//    val _s = s.filter { it.isLetterOrDigit() }.lowercase()
//    for (i in 0..<_s.length/2) {
//        if (_s[i] != _s[_s.length-1 - i])
//            return false
//    }
//    return true

    // if can't use std lib function to filter,
    // create new string filtering manually ascii codes
    //
//    var _s = ""
//    s.forEach {
//        if (it.code in 65..90) _s += (it.code + 32).toChar() // uppercase letter, changing to lowercase
//        else if (it.code in 97..122) _s += it                // lowercase letter
//        else if (it.code in 48..57) _s += it                 // digit
//    }
//    println(_s)
//    for (i in 0..<_s.length/2) {
//        if (_s[i] != _s[_s.length-1 - i])
//            return false
//    }
//    return true


    // O(N) time, O(1) space solution:
    // check ascii codes with two pointers
    fun Char.isLetterOrDigit(): Boolean {
        if (this.code in 65..90) return true
        if (this.code in 97..122) return true
        if (this.code in 48..57) return true
        return false
    }

    fun Char.lowercase(): Char {
        return if (this.code in 65..90)
            (this.code + 32).toChar()
        else this
    }

    if (s.isEmpty()) return true

    var l = 0
    var r = s.length-1
    while (l < r) {
        if (!s[l].isLetterOrDigit()) {
            l++
            continue
        }
        if (!s[r].isLetterOrDigit()) {
            r--
            continue
        }
        if (s[l].lowercase() != s[r].lowercase())
            return false
        l++
        r--
    }
    return true
}

fun main() {
    println()
    var s = "A man, a plan, a canal: Panama"
    println("s = $s")
    println(isPalindrome(s))
    println("true is expected")


    println()
    s = "race a car"
    println("s = $s")
    println(isPalindrome(s))
    println("false is expected")

    println()
    s = " "
    println("s = $s")
    println(isPalindrome(s))
    println("true is expected")

    println()
    s = ""
    println("s = $s")
    println(isPalindrome(s))
    println("true is expected")

    println()
    s = "0123456789A man, a plan, a canal: Panama9876543210"
    println("s = $s")
    println(isPalindrome(s))
    println("true is expected")
}





// https://leetcode.com/problems/top-k-frequent-elements/
fun topKFrequent(nums: IntArray, k: Int): IntArray {
    // O(NlogN) time, O(N) space solution :
    //
    // hashmap with key = number, value = frequency
    //
    // go through nums for O(N)
    // for each element check if (frequency[number] == null)
    // true -> frequency[number] = 1
    // false -> frequency[number]++
    //
    // sort hashmap descending by frequency for O(NlogN)
    // return first K

//    val count = HashMap<Int, Int>() // O(N) space in worst case
//    for (num in nums) {
//        if (count[num] == null) {
//            count[num] = 1
//        } else {
//            count[num] = count[num]!! + 1
//        }
//    }
//    val sorted = mutableListOf<Pair<Int, Int>>() // O(N) space in worst case
//    for ((num, freq) in count) {
//        sorted.add(Pair(num, freq))
//    }
//    sorted.sortByDescending { it.second }
//    val result = IntArray(k)
//    for (i in 0..<k) {
//        result[i] = sorted[i].first
//    }
//    return result

    // O(N) time, O(N) space solution:
    //
    // instead of sorting in previous solution
    // create an array freqArray of size nums.size + 1
    // consisting of lists
    // and for each (num, freq) in hashmap
    // do freqArray[freq].add(num)
    // then for i in freqArray.size..1
    // for num in freqArray[i]
    // result.add(num)
    // if result.size == k, return result
    // worst case is when k ~ nums.size => O(N)

    val count = HashMap<Int, Int>() // O(N) space in worst case
    for (num in nums) {
        if (count[num] == null) {
            count[num] = 1
        } else {
            count[num] = count[num]!! + 1
        }
    }
    val freqLists = List(nums.size + 1) { mutableListOf<Int>() } // O(N) space
    for ((num, freq) in count) {
        freqLists[freq].add(num)
    }
    val result = mutableListOf<Int>()
    for (i in freqLists.size - 1 downTo 0) {
        for (num in freqLists[i]) {
            result.add(num)
            if (result.size == k) return result.toIntArray()
        }
    }
    return result.toIntArray()
}

//fun main() {
//    println("nums = [1,1,1,2,2,3], k = 2")
//    topKFrequent(intArrayOf(1,1,1,2,2,3), 2).forEach { print("$it ") }
//    println()
//    println("expected: [1, 2]")
//    println()
//
//    println("nums = [1], k = 1")
//    topKFrequent(intArrayOf(1), 1).forEach { print("$it ") }
//    println()
//    println("expected: [1]")
//    println()
//
//    println("nums = [1,1,2,3], k = 2")
//    topKFrequent(intArrayOf(1,1,2,3), 2).forEach { print("$it ") }
//    println()
//    println("expected: [1, 2]")
//    println()
//
//    println("nums = [1,1,2,3], k = 1")
//    topKFrequent(intArrayOf(1,1,2,3), 1).forEach { print("$it ") }
//    println()
//    println("expected: [1]")
//    println()
//
//    println("nums = [1,1,2,3], k = 3")
//    topKFrequent(intArrayOf(1,1,2,3), 3).forEach { print("$it ") }
//    println()
//    println("expected: [1, 2, 3]")
//    println()
//
//    println("nums = [1,1,2,2,3], k = 2")
//    topKFrequent(intArrayOf(1,1,2,2,3), 2).forEach { print("$it ") }
//    println()
//    println("expected: [1, 2]")
//    println()
//
//    println("nums = [1,1,2,2,3,3], k = 2")
//    topKFrequent(intArrayOf(1,1,2,2,3,3), 2).forEach { print("$it ") }
//    println()
//    println("expected: [1, 2]")
//    println()
//
//    println("nums = [2,2,1,1,3,3], k = 2")
//    topKFrequent(intArrayOf(2,2,1,1,3,3), 2).forEach { print("$it ") }
//    println()
//    println("expected: [1, 2] or [2, 1] (?)")
//    println()
//}





// https://leetcode.com/problems/group-anagrams/
fun groupAnagrams(strs: Array<String>): List<List<String>> {
    // N^2 solution : for each strs[i] search its anagrams?

    // NMlogM solution :
    // create a hash map, key = sorted_word, value = list of anagrams
    // go through array
    // check if map[word.sorted()] exists
    // yes -> map[word.sorted()].add(word)
    // no -> map[word.sorted()] = listOf(word)

    val map = hashMapOf<List<Char>, MutableList<String>>()
    strs.forEach { word ->
        val sortedWord = word.toCharArray().sorted()
        if (map[sortedWord] != null) {
            map[sortedWord]?.add(word)
        } else {
            map[sortedWord] = mutableListOf(word)
        }
    }
    val result = mutableListOf<List<String>>()
    map.forEach { (key, value) ->
        result.add(value)
    }
    return result
}

//fun main() {
//    groupAnagrams(arrayOf("eat","tea","tan","ate","nat","bat")).forEach {
//        it.forEach {
//            print("$it, ")
//        }
//        println()
//    }
//    println("1. expected:")
//    listOf(listOf("bat"), listOf("nat","tan"), listOf("ate","eat","tea")).forEach {
//        it.forEach {
//            print("$it, ")
//        }
//        println()
//    }
//    println()
//
//    groupAnagrams(arrayOf("")).forEach {
//        it.forEach {
//            print("$it, ")
//        }
//        println()
//    }
//    println("2. expected:")
//    listOf("").forEach {
//        it.forEach {
//            print("$it, ")
//        }
//        println()
//    }
//    println()
//
//    groupAnagrams(arrayOf("a")).forEach {
//        it.forEach {
//            print("$it, ")
//        }
//        println()
//    }
//    println("3. expected:")
//    listOf(listOf("a")).forEach {
//        it.forEach {
//            print("$it, ")
//        }
//        println()
//    }
//    println()
//}





// https://leetcode.com/problems/two-sum/
fun twoSum(nums: IntArray, target: Int): IntArray {
    // 1. N^2 solution : for a[i] search if a[i] + a[j] == target with j = i+1..a.size
    // 2. NlogN solution : sort for NlogN, for a[i] do binary search in range i+1..a.size
    // 3. NlogN solution : sort for NlogN, for a[i] use two pointers method
    // 4. N solution : create a hash map, for each a[i] check if there is its complement in the hash, if not -> add it

    if (nums.size < 2) return intArrayOf()

//    for (i in nums.indices) {
//        for (j in i+1 until nums.size) {
//            if (nums[i] + nums[j] == target) {
//                return intArrayOf(i, j)
//            }
//        }
//    }
//    return intArrayOf()

//    val numsIndexed = nums.mapIndexed { index, value -> Pair(value, index) }.sortedBy { it.first }
//    fun binarySearch(l: Int, r: Int, value: Int): Int {
//        if (l > r) return -1
//        val m = (l + r) / 2
//        if (numsIndexed[m].first < value) return binarySearch(m + 1, r, value)
//        if (numsIndexed[m].first > value) return binarySearch(l, m - 1, value)
//        if (numsIndexed[m].first == value) return m
//        else return -1
//    }
//    for (i in numsIndexed.indices) {
//        val complement = target - numsIndexed[i].first
//        val j = binarySearch(i+1, nums.size-1, complement)
//        if (j != -1) return intArrayOf(numsIndexed[i].second, numsIndexed[j].second)
//    }
//    return intArrayOf()

//    val numsIndexed = nums.mapIndexed { index, value -> Pair(value, index) }.sortedBy { it.first }
//    var l = 0
//    var r = numsIndexed.size - 1
//    while (l < r) {
//        if (numsIndexed[l].first + numsIndexed[r].first < target) {
//            l++
//        } else if (numsIndexed[l].first + numsIndexed[r].first > target) {
//            r--
//        } else {
//            return intArrayOf(numsIndexed[l].second, numsIndexed[r].second)
//        }
//    }
//    return intArrayOf()

    val complements = hashMapOf<Int, Pair<Int, Int>>()
    nums.forEachIndexed { index, value ->
        if (complements[value]?.first == value)
            return intArrayOf(complements[value]!!.second, index)
        else
            complements[target - value] = Pair(target - value, index)
    }
    return intArrayOf()
}

//fun main() {
//    twoSum(intArrayOf(2, 7, 11, 15), 9).forEach { print(it) }
//    println()
//    twoSum(intArrayOf(3, 2, 4), 6).forEach { print(it) }
//    println()
//    twoSum(intArrayOf(3, 3), 6).forEach { print(it) }
//    println()
//    twoSum(intArrayOf(0, 4, 3, 0), 0).forEach { print(it) }
//    println()
//    twoSum(intArrayOf(3, 2, 3), 6).forEach { print(it) }
//    println()
//}





// https://leetcode.com/problems/valid-anagram/
fun isAnagram(s: String, t: String): Boolean {
    // 1. (S+T)log(S+T) solution : sort both strings, check if they are equal
    // 2. S+T solution : create a hash map for letters count, ++hashmap[letter] for each letter in s, --hashmap[letter] for each letter in t, if hashmap.any != 0 -> return false, else return true

    if (s.length != t.length)
        return false

//    val sList = s.toMutableList()
//    val tList = t.toMutableList()
//    sList.sort()
//    tList.sort()
//    return sList == tList

//    val lttrsCount = hashMapOf<Char, Int>()
//    s.forEach {
//        lttrsCount[it] = lttrsCount.getOrDefault(it, 0) + 1
//    }
//    t.forEach {
//        lttrsCount[it] = lttrsCount.getOrDefault(it, 0) - 1
//    }
//    return lttrsCount.all { it.value == 0 }


    val lettersCount = IntArray(26)
    for (letter in s) ++lettersCount[letter - 'a']
    for (letter in t) --lettersCount[letter - 'a']
    return lettersCount.all { it == 0 }
}

//fun main() {
//    println(isAnagram("aa", "aa"))
//    println(isAnagram("anagram", "nagaram"))
//    println(isAnagram("rat", "car"))
//    println(isAnagram("ab", "a"))
//    println(isAnagram("aacc", "ccac"))
//}





// https://leetcode.com/problems/contains-duplicate/
fun containsDuplicate(nums: IntArray): Boolean {
    // 1. N^2 solution : for each a[i] search in range (i+1, array.size()) for its duplicate. N(N+1)/2 total operations
    // 2. NlogN solution : array.sort() for NlogN, then go through array checking if a[i] == a[i+1].
    // 3. N solution : create a hash set, go through array checking for O(1) if element i is in the hash set, if yes -> return 'yes', if not -> add it to hash set and move next
    // 4. <= logN solution? probably no

//    for (i in nums.indices)
//        for (j in i + 1 until nums.size)
//            if (nums[i] == nums[j]) return true
//    return false


//    nums.sort()
//    nums.forEachIndexed{ index, i ->
//        if (index + 1 < nums.size && i == nums[index + 1])
//            return true
//    }
//    println()
//    return false

    val hashSet = hashSetOf<Int>()
    nums.forEach {
        if (hashSet.contains(it))
            return true
        hashSet.add(it)
    }
    return false
}

//fun main() {
//    println(containsDuplicate(intArrayOf(1, 2, 3, 1)))
//    println(containsDuplicate(intArrayOf(1, 2, 3, 4)))
//    println(containsDuplicate(intArrayOf(1,1,1,3,3,4,3,2,4,2)))
//}
