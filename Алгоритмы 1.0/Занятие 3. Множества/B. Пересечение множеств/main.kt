/*
  Пока не дорешал

  https://contest.yandex.ru/contest/27663/problems/B/

  Даны два списка чисел, которые могут содержать до 10000 чисел каждый.
  Выведите все числа, которые входят как в первый, так и во второй список в порядке возрастания.
  Примечание. И даже эту задачу на Питоне можно решить в одну строчку.

  Формат ввода:
  Вводятся два списка целых чисел. Все числа каждого списка находятся на отдельной строке.

  Формат вывода:
  Выведите ответ на задачу.

  Пример 1:
  1 3 2
  4 3 2
  Вывод:
  2 3

  Пример 2:
  1 2 6 4 5 7
  10 2 3 4 8
  Вывод:
  2 4

  Примечания:
  Ввод и вывод осуществлять с помощью файлов
 */

import java.io.File

 fun main() {
    val lines = File("input.txt").forEachLine {
        line
            ?.split(" ")
            ?.map { it.toInt() }
            ?.distinct() ?: emptyList()
    }

    val input = File("input.txt")

    var first: List<Int>
    var second: List<Int>

    val first = File("input.txt").readLine()?.split(" ")?.map { it.toInt() }?.distinct()

    val lines: List<List<Int>> = File("input.txt").forEachLine { line ->
        if (!first.contains())
        line
            ?.split(" ")
            ?.map { it.toInt() }
            ?.distinct() ?: emptyList()
    }

    File("output.txt").bufferedWriter().use { writer ->
        input.useLines { lines ->
            lines.forEach { word ->
                val result = toPlural(word)
                writer.write("$result")
                writer.newLine()
            }
        }
    }

    val first = readLine()?.split(" ")?.map { it.toInt() }?.distinct() ?: emptyList()
    val second = readLine()?.split(" ")?.map { it.toInt() }?.distinct() ?: emptyList()
    println(first.intersect(second).sorted())
 }