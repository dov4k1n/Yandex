// https://leetcode.com/problems/top-k-frequent-elements/
fun topKFrequent(nums: IntArray, k: Int): IntArray {
    // O(NlogN) solution :
    //
    // hashmap with key = number, value = frequency
    //
    // go through nums for O(N)
    // for each element check if (frequency[number] != null)
    // true -> frequency[number]++
    // false -> frequency[number] = 1
    //
    // sort hashmap by frequency for O(NlogN)
    // return first K

    // 


    return intArrayOf(1, 2, 3)
}

fun main() {
    println("nums = [1,1,1,2,2,3], k = 2")
    topKFrequent(intArrayOf(1,1,1,2,2,3), 2).forEach { print("$it ") }
    println()
    println("expected: [1, 2]")
    println()

    println("nums = [1], k = 1")
    topKFrequent(intArrayOf(1), 1).forEach { print("$it ") }
    println()
    println("expected: [1]")
    println()

    println("nums = [1,1,2,3], k = 2")
    topKFrequent(intArrayOf(1,1,2,3), 2).forEach { print("$it ") }
    println()
    println("expected: [1, 2]")
    println()

    println("nums = [1,1,2,3], k = 1")
    topKFrequent(intArrayOf(1,1,2,3), 1).forEach { print("$it ") }
    println()
    println("expected: [1]")
    println()

    println("nums = [1,1,2,3], k = 3")
    topKFrequent(intArrayOf(1,1,2,3), 3).forEach { print("$it ") }
    println()
    println("expected: [1, 2, 3]")
    println()

    println("nums = [1,1,2,2,3], k = 2")
    topKFrequent(intArrayOf(1,1,2,2,3), 2).forEach { print("$it ") }
    println()
    println("expected: [1, 2]")
    println()

    println("nums = [1,1,2,2,3,3], k = 2")
    topKFrequent(intArrayOf(1,1,2,2,3,3), 2).forEach { print("$it ") }
    println()
    println("expected: [1, 2]")
    println()

    println("nums = [2,2,1,1,3,3], k = 2")
    topKFrequent(intArrayOf(2,2,1,1,3,3), 2).forEach { print("$it ") }
    println()
    println("expected: [1, 2] or [2, 1] (?)")
    println()
}

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
