/*
  https://contest.yandex.ru/contest/27663/problems/C/

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
import java.io.PrintWriter
import java.util.*

fun main() {
    ///////////////// TEST 5: TIME-LIMIT-EXCEEDED
    // val (N, M) = readLine()!!.split(" ").map { it.toInt() }

    // val anyaColors = mutableSetOf<Int>()
    // val boryaColors = mutableSetOf<Int>()
    
    ///////////////// THIS IS THE REASON OF TIME-LIMIT-EXCEEDED
    ///////////////// BETTER TO USE .forEach()
    // repeat(N) {
    //     anyaColors.add(readLine()!!.toInt())
    // }
    // repeat(M) {
    //     boryaColors.add(readLine()!!.toInt())
    // }

    // val commonColors = anyaColors.intersect(boryaColors).sorted()
    // println(commonColors.size)
    // commonColors.forEach { print("$it ")}
    // println()

    // val anyaComplement = anyaColors.subtract(commonColors).sorted()
    // println(anyaComplement.size)
    // anyaComplement.forEach { print("$it ")}
    // println()
    
    // val boryaComplement = boryaColors.subtract(commonColors).sorted()
    // println(boryaComplement.size)
    // boryaComplement.forEach { print("$it ")}

    
    ///////////////// BEST SOLUTION

    ///////////////// TIMER
    // import java.util.*

    val startTime = System.currentTimeMillis()

    val timer = Timer()
    timer.schedule(object : TimerTask() {
        override fun run() {
            val elapsedTime = System.currentTimeMillis() - startTime
            println("Время обработки: ${elapsedTime} миллисекунд")
        }
    }, 0, 1000) // Вывод каждые 1000 миллисекунд (1 секунда)

    val file = File("input.txt")
    val (n, m) = file.readLines()[0].split(" ").map { it.toInt() }

    ///////////////// BETTER TO USE HashSet()
    //val anyaColors = HashSet<Int>()
    //val boryaColors = HashSet<Int>()
    val anyaColors = mutableSetOf<Int>()
    val boryaColors = mutableSetOf<Int>()

    var startingTime = System.currentTimeMillis() - startTime
    println("starting reading anya at $startingTime")
    file.readLines().subList(1, n + 1).forEach { 
        // println("reading anya $it")
        anyaColors.add(it.toInt()) 
    }
    var tookTime = System.currentTimeMillis() - startTime - startingTime
    println("finished reading anya at ${System.currentTimeMillis() - startTime} in $tookTime milliseconds")
    
    
    startingTime = System.currentTimeMillis() - startTime
    println("starting reading borya at $startingTime")
    file.readLines().subList(n + 1, n + m + 1).forEach { 
        // println("reading borya $it")
        boryaColors.add(it.toInt()) 
    }
    tookTime = System.currentTimeMillis() - startTime - startingTime
    println("finished reading borya at ${System.currentTimeMillis() - startTime} in $tookTime milliseconds")
    

    startingTime = System.currentTimeMillis() - startTime
    println("starting intersecting at $startingTime")
    val commonColors = anyaColors.intersect(boryaColors).sortedBy { it }
    tookTime = System.currentTimeMillis() - startTime - startingTime
    println("intersecting finished at ${System.currentTimeMillis() - startTime} in $tookTime milliseconds")
    
    startingTime = System.currentTimeMillis() - startTime
    println("starting anya subtracting at $startingTime")
    val anyaComplement = anyaColors.subtract(commonColors).sortedBy { it }
    tookTime = System.currentTimeMillis() - startTime - startingTime
    println("anya subtracting finished at ${System.currentTimeMillis() - startTime} in $tookTime milliseconds")
    
    startingTime = System.currentTimeMillis() - startTime
    println("starting borya subtracting at $startingTime")
    val boryaComplement = boryaColors.subtract(commonColors).sortedBy { it }
    tookTime = System.currentTimeMillis() - startTime - startingTime
    println("borya subtracting finished at ${System.currentTimeMillis() - startTime} in $tookTime milliseconds")
    
    PrintWriter(File("output.txt")).use { out ->
        out.println(commonColors.size)
        commonColors.forEach { out.print("$it ") }
        out.println()

        out.println(anyaComplement.size)
        anyaComplement.forEach { out.print("$it ") }
        out.println()

        out.println(boryaComplement.size)
        boryaComplement.forEach { out.print("$it ") }
    }

    timer.cancel()
}