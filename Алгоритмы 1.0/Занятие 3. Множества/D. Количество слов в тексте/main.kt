/*
  https://contest.yandex.ru/contest/27663/problems/D/

  Во входном файле (вы можете читать данные из sys.stdin, подключив
  библиотеку sys) записан текст. Словом считается последовательность
  непробельных символов идущих подряд, слова разделены одним или большим
  числом пробелов или символами конца строки. Определите, сколько различных
  слов содержится в этом тексте.

  # Формат ввода:
  Вводится текст.

  # Формат вывода:
  Выведите ответ на задачу.

  # Пример:
  ~~~~~~~~~ Ввод:
  She sells sea shells on the sea shore;
  The shells that she sells are sea shells I'm sure.
  So if she sells sea shells on the sea shore,
  I'm sure that the shells are sea shore shells.
  ~~~~~~~~~ Вывод:
  19

  explanation:
  She sells sea shells on the shore;
  The that she are I'm sure.
  So if shore,
  sure shore shells.
 */

import java.io.File

fun main() {
    val input = File("input.txt").readText()

    val result: MutableSet<String> = mutableSetOf()

    var word = ""

    for (char in input) {
        if (char != ' ' && char != '\n' && char != '\r') {
            word += char
        } else if (word != "") {
            result.add(word)
            word = ""
        }
    }
    if (word != "") result.add(word)
    File("output.txt").writeText(result.size.toString())
}