# Overview

## Languages default implementations

Data structure | Kotlin | Java | C++
:---:| :---:| :---:| :---:
|[Array primitive type](https://kotlinlang.org/docs/arrays.html#primitive-type-arrays)|`IntArray`, `CharArray`, etc|`int[]`, `char[]`|`int[]`, `char[]`
|[Array](#array)|`Array`|`Array`|`std::array`
|[Dynamic Array](#dynamic-array)|`List` (ArrayList)|`ArrayList`|`std::vector`
|Linked List singly|||`std::forward_list`
|Linked List doubly||`LinkedList`|`std::list`
|[Set ordered by insertion](#set-ordered)|`Set` (LinkedHashSet)|`LinkedHashSet`|
|Set ordered by key||`TreeSet`|`std::set`
|[Set unordered](#set-unordered)|`HashSet`|`HashSet`|`std::unordered_set`
|[Map ordered by insertion](#map-ordered-by-insertion)|`Map` (LinkedHashMap)|`LinkedHashMap`|
|Map ordered by key||`TreeMap`|`std::ordered_map`
|[Map unordered](#map-unordered)|`HashMap`|`HashMap`|`std::unordered_map`
|[Stack](#stack)|`ArrayDeque`|`Stack`|`std::stack`
|[Queue](#queue)|`ArrayDeque`|`Queue`|`std::queue`
|[Deque](#deque)|`ArrayDeque`|`ArrayDeque`|`std::deque`
|Heap||`PriorityQueue`|`std::priority_queue`

> [!NOTE]
> All classes in `Java`'s column are available in Kotlin via `import java.util.<class name>`
> 
> Classes in `Kotlin`'s column are *those who don't require explicit import from Java*, even if under the hood Kotlin imports them itself. See Kotlin type aliases:
  > ```kotlin
  > @SinceKotlin("1.1") public actual typealias ArrayList<E> = java.util.ArrayList<E>
  >
  > @SinceKotlin("1.1") public actual typealias LinkedHashMap<K, V> = java.util.LinkedHashMap<K, V>
  >
  > @SinceKotlin("1.1") public actual typealias HashMap<K, V> = java.util.HashMap<K, V>
  >
  > @SinceKotlin("1.1") public actual typealias LinkedHashSet<E> = java.util.LinkedHashSet<E>
  >
  > @SinceKotlin("1.1") public actual typealias HashSet<E> = java.util.HashSet<E>
  > ```

### Resources used: 

1. https://www.youtube.com/live/7pbG923ubQE
2. https://kotlinlang.org/docs/collections-overview.html
3. https://kotlinlang.org/docs/arrays.html
4. https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/
5. https://github.com/JetBrains/kotlin/tree/master/libraries/stdlib/src/kotlin/collections
6. https://en.cppreference.com/w/cpp/container
7. https://www.geeksforgeeks.org/collections-in-java-2/
8. https://dsakt.github.io/docs/overview/