fun main() {
    print("Enter temperature: ")
    val temperatureInput = readLine()

    print("Enter mode (freeze/heat/auto/fan): ")
    val mode = readLine()

    if (temperatureInput != null && mode != null) {
        val temperatures = temperatureInput.split(" ")

        if (temperatures.size == 2) {
            val tRoom = temperatures[0].toInt()
            val tCond = temperatures[1].toInt()

            when (mode) {
                "freeze" -> {
                    if (tCond < tRoom) println(tCond)
                    else println(tRoom)
                }

                "heat" -> {
                    if (tCond > tRoom) println(tCond)
                    else println(tRoom)
                }

                "auto" -> println(tCond)

                "fan" -> println(tRoom)

                else -> println("Wrong input for mode")
            }
        } else {
            println("Temperature input must contain two parts separated by a space.")
        }
    } else {
        println("Input is null. Please enter valid values.")
    }
}