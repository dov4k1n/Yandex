/*
  https://contest.yandex.ru/contest/27663/problems/B/

  Даны два списка чисел, которые могут содержать до 10000 чисел каждый.
  Выведите все числа, которые входят как в первый, так и во второй список в порядке возрастания.
  Примечание. И даже эту задачу на Питоне можно решить в одну строчку.

  # Формат ввода:
  Вводятся два списка целых чисел. Все числа каждого списка находятся на отдельной строке.

  # Формат вывода:
  Выведите ответ на задачу.

  # Пример 1:
  ~~~~~~~~~ Ввод:
  1 3 2
  4 3 2
  ~~~~~~~~~ Вывод:
  2 3

  # Пример 2:
  ~~~~~~~~~ Ввод:
  1 2 6 4 5 7
  10 2 3 4 8
  ~~~~~~~~~ Вывод:
  2 4

  # Примечания:
  Ввод и вывод осуществлять с помощью файлов
 */

import java.io.File

fun main() {
  val lines = File("input.txt").readLines()

  val intersection = lines
    .map { line -> line.split(" ").mapNotNull { it.toIntOrNull() }.toSet() }
    .reduce { acc, set -> acc.intersect(set) }

  File("output.txt").writeText(intersection.sorted().joinToString(" "))

  // var intersection: Set<Int>? = null

  // File("input.txt").forEachLine { line ->
  //   val numbers = line.split(" ")
  //     .asSequence()
  //     .mapNotNull { it.toIntOrNull() }
  //     .toSet()

  //   intersection = if (intersection == null) {
  //     numbers
  //   } else {
  //     intersection!!.intersect(numbers)
  //   }
  // }

  // File("output.txt").bufferedWriter().use { writer ->
  //   intersection?.sorted()?.forEach { number ->
  //     writer.write("$number ")
  //   }
  // }
}