/*
  https://contest.yandex.ru/contest/27663/problems/C/

  TL;DR:
    даются два множества, вывести сортированное пересечение,
    а потом сортированные дополнения,
    но перед каждым выводом сначала вывести размер.

  Аня и Боря любят играть в разноцветные кубики, причем у каждого из них
  свой набор и в каждом наборе все кубики различны по цвету.

  Однажды дети заинтересовались,
  сколько существуют цветов таких, что
  кубики каждого цвета присутствуют в обоих наборах.

  Для этого они занумеровали все цвета случайными числами.
  На этом их энтузиазм иссяк, поэтому вам предлагается помочь им
  в оставшейся части.
  Номер любого цвета — это целое число в пределах от 0 до 10^9.

  # Формат ввода:
  В первой строке входного файла записаны числа N и M
  — количество кубиков у Ани и Бори соответственно.
  В следующих N строках заданы номера цветов кубиков Ани.
  В последних M строках номера цветов кубиков Бори.

  # Формат вывода:
  Выведите сначала количество, а затем отсортированные по возрастанию
  номера цветов таких, что кубики каждого цвета есть в обоих наборах,
  затем количество и отсортированные по возрастанию номера остальных цветов у Ани,
  потом количество и отсортированные по возрастанию номера остальных цветов у Бори.

  # Пример 1:
  ~~~~~~~~~ Ввод:
  4 3
  0
  1
  10
  9
  1
  3
  0
  ~~~~~~~~~ Вывод:
  2
  0 1
  2
  9 10
  1
  3

  # Пример 2:
  ~~~~~~~~~ Ввод:
  2 2
  1
  2
  2
  3
  ~~~~~~~~~ Вывод:
  1
  2
  1
  1
  1
  3

  # Пример 3:
  ~~~~~~~~~ Ввод:
  0 0
  ~~~~~~~~~ Вывод:
  0

  0

  0

 */

import java.io.File

fun main() {
  val file = File("input.txt")

  val (n, m) = file.readLines()[0].split(" ").map { it.toInt() }

  val anyaColors = mutableSetOf<Int>()
  file.readLines().subList(1, n + 1).forEach { anyaColors.add(it.toInt()) }

  val boryaColors = mutableSetOf<Int>()
  file.readLines().subList(n + 1, n + m + 1).forEach { boryaColors.add(it.toInt()) }

  val commonColors = anyaColors.intersect(boryaColors).toSortedSet()
  val anyaComplement = anyaColors.subtract(commonColors).toSortedSet()
  val boryaComplement = boryaColors.subtract(commonColors).toSortedSet()

  File("output.txt").writeText(
    buildString {
      appendLine(commonColors.size)
      appendLine(commonColors.joinToString(" "))
      appendLine(anyaComplement.size)
      appendLine(anyaComplement.joinToString(" "))
      appendLine(boryaComplement.size)
      appendLine(boryaComplement.joinToString(" "))
    }
  )
}