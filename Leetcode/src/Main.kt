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
