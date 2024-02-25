/*
    ax + by = e,
    cx + dy = f

    Вводятся действительные a, b, c, d, e, f.
    Вывод программы зависит от вида решения этой системы.
    0. Если система не имеет решений, то программа должна вывести единственное число 0.
    1. Если система имеет бесконечно много решений, каждое из которых имеет вид y=kx+b, то программа должна вывести число 1, а затем значения k и b. 
    2. Если система имеет единственное решение (x0,y0), то программа должна вывести число 2, а затем значения x0 и y0. 
    3. Если система имеет бесконечно много решений вида x=x0, y — любое, то программа должна вывести число 3, а затем значение x0.
    4. Если система имеет бесконечно много решений вида y=y0, x — любое, то программа должна вывести число 4, а затем значение y0. 
    5. Если любая пара чисел (x,y) является решением, то программа должна вывести число 5.

    Числа x0 и y0 будут проверяться с точностью до пяти знаков после точки.
*/

import kotlin.math.abs

fun solve(a: Double, b: Double, c: Double, d: Double, e: Double, f: Double): String {
    val det = a*d - b*c
    val det_x = e*d - f*b
    val det_y = a*f - c*e

    val epsilon = 0.00001

    if (abs(det) >= epsilon) return "2 ${det_x / det} ${det_y / det}"
    
    else {
        if (
            abs(a) < epsilon && abs(b) < epsilon && abs(c) < epsilon &&
            abs(d) < epsilon && abs(e) < epsilon && abs(f) < epsilon
        )
            return "5"

        if (abs(a) < epsilon && abs(b) < epsilon && abs(e) >= epsilon)
            return "0"

        if (abs(c) < epsilon && abs(d) < epsilon && abs(f) >= epsilon)
            return "0"

        if (abs(det_x) < epsilon) {
            if (abs(a) < epsilon && abs(c) < epsilon)
                return if (abs(d) < epsilon)
                    "4 ${e / b}"
                else
                    "4 ${f / d}"

            if (abs(b) < epsilon && abs(d) < epsilon)
                return if (abs(c) < epsilon)
                    "3 ${e / a}"
                else
                    "3 ${f / c}"

            return if (abs(d) < epsilon)
                "1 ${(-1) * a / b} ${e / b}"
            else
                "1 ${(-1) * c / d} ${f / d}"
        }

        return "0"
    }
}

fun main() {
    val a = readLine()?.toDouble() ?: 0.0
    val b = readLine()?.toDouble() ?: 0.0
    val c = readLine()?.toDouble() ?: 0.0
    val d = readLine()?.toDouble() ?: 0.0
    val e = readLine()?.toDouble() ?: 0.0
    val f = readLine()?.toDouble() ?: 0.0

    println(solve(a, b, c, d, e, f))
}