```kotlin
val grid: Array<CharArray> = arrayOf(
    charArrayOf('a', 'b', 'c'),
    charArrayOf('d', 'e', 'f'),
    charArrayOf('g', 'h', 'i')
)

// Create a deep copy of the grid
val gridDeepCopy = grid.map { it.copyOf() }.toTypedArray()
// .map() returns List<CharArray>
// .toTypedArray() converts it back to the CharArray

// Create a shallow copies of the grid
val gridShallowCopy = grid
val gridShallowCopy2 = grid.copyOf()

// Modify the copy to verify it doesn't affect the original
gridCopy[0][0] = 'x'

println("Original grid:")
grid.forEach { println(it.joinToString("")) }

println("\nCopied grid:")
gridCopy.forEach { println(it.joinToString("")) }
```

output:

```
Original grid:
abc
def
ghi

Copied grid:
xbc
def
ghi
```

What Does `copyOf()` Do?
* The `copyOf()` function creates a new array with the same size and copies the references of the elements from the original array into the new array.
* For an `Array<CharArray>`, this means:
  * A new `Array` is created.
  * Each element (which is a `CharArray`) is copied by reference, not by value.