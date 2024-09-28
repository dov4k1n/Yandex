/*
  https://contest.yandex.ru/contest/27663/problems/A/
  
  Дан список чисел, который может содержать до 100000 чисел.
  Определите, сколько в нем встречается различных чисел.

  Формат ввода:
  Вводится список целых чисел. Все числа списка находятся на одной строке.

  Формат вывода:
  Выведите ответ на задачу.

  Пример 1:
  1 2 3 2 1
  Вывод:
  3

  Пример 2:
  1 2 3 4 5 6 7 8 9 10
  Вывод:
  10

  Пример 3:
  1 2 3 4 5 1 2 1 2 7 3
  Вывод:
  6
 */

 fun main() {
    // val input = readLine()?.split(" ")?.map { it.toInt() } ?: emptyList()
    // val set: MutableSet<Int> = mutableSetOf()
    // for (number in input) {
    //     if (!set.contains(number)) {
    //         set.add(number)
    //     }
    // }
    // println(set.count())

    val input = readLine()?.split(" ")?.map { it.toInt() }?.distinct() ?: emptyList()
    println(input.count())
 }