/*
1. delay() is a special suspending function provided by the Kotlin coroutines library. 
    Execution of the main() function will suspend (or pause) at this point, 
    and then resume once the specified duration of the delay is over.

    If you try to run your program at this point, there will be a compile error: 
    Suspend function 'delay' should be called only from a coroutine or another suspend function.

    For the purposes of learning coroutines within the Kotlin Playground, 
    you can wrap your existing code with a call to the runBlocking() function from the coroutines library. 
    runBlocking() runs an event loop, which can handle multiple tasks at once by continuing each task 
    where it left off when it's ready to be resumed.

    runBlocking() is synchronous; it will not return until all work within its lambda block is completed.

2. A suspending function is like a regular function, but it can be suspended and resumed again later. 
    To do this, suspend functions can only be called from other suspend functions that make this capability available.

    A suspending function may contain zero or more *uspension points. 
    A suspension point is the place within the function where execution of the function can suspend. 
    Once execution resumes, it picks up where it last left off in the code and proceeds with the rest of the function.

3. Use the launch() function from the coroutines library to launch a new coroutine. 
    To execute tasks concurrently, add multiple launch() functions to your code so that 
    multiple coroutines can be in progress at the same time.

4. Use the async() function from the coroutines library if you care about when the coroutine finishes 
    and need a return value from it.

    The async() function returns an object of type Deferred, which is like a promise that the result will be in there 
    when it's ready. You can access the result on the Deferred object using await().
 */

import kotlin.system.*
import kotlinx.coroutines.*

suspend fun getForecast(): String {
    delay(1000)
    return "Sunny"
}

suspend fun getTemperature(): String {
    delay(1000)
    return "30\u00b0C"
}

fun first_main() {
    val time = measureTimeMillis {
        runBlocking {
            println("Weather forecast")
            println(getForecast())
            println(getTemperature())
        }
    }
    println("Execution time: ${time / 1000.0} seconds")
}
/*
    output:
        Weather forecast
        Sunny
        30°C
        Execution time: 2.096 seconds
 */

fun second_main() {
    val time = measureTimeMillis {
        runBlocking {
            println("Weather forecast")
            
            launch {
                println(getForecast())
            }
            
            launch {
                println(getTemperature())
            }
        }
    }
    println("Execution time: ${time / 1000.0} seconds")
}
/*
    output:
        Weather forecast
        Sunny
        30°C
        Execution time: 1.109 seconds

    The call to launch { printForecast() } can return before all the work in printForecast() is completed. 
    That is the beauty of coroutines. You can move onto the next launch() call to start the next coroutine. 
    Similarly, the launch { printTemperature() } also returns even before all work is completed.
 */

fun third_main() {
    val time = measureTimeMillis {
        runBlocking {
            println("Weather forecast")

            launch {
                println(getForecast())
            }

            launch {
                println(getTemperature())
            }

            println("Have a good day!")
        }
    }
    println("Execution time: ${time / 1000.0} seconds")
}

/*
    output:
        Weather forecast
        Have a good day!
        Sunny
        30°C
        Execution time: 1.125 seconds

    From this output, you can observe that after the two new coroutines are launched 
    for println(getForecast()) and println(getTemperature()), you can proceed with the next 
    instruction which prints "Have a good day!". This demonstrates the "fire and forget" nature of launch(). 
    You fire off a new coroutine with launch(), and don't have to worry about when its work is finished.

    Later the coroutines will complete their work, and print the remaining output statements. 
    Once all the work (including all coroutines) in the body of the runBlocking() call have been completed, 
    then runBlocking() returns and the program ends.
 */

fun fourth_main() {
    val time = measureTimeMillis {
        runBlocking { 
            println("Weather forecast")

            val forecast: Deferred<String> = async {
            	getForecast()
        	}

        	val temperature: Deferred<String> = async {
        	    getTemperature()
        	}

            println("${forecast.await()} ${temperature.await()}")

            println("Have a good day!")
        }
    }
    println("Execution time: ${time / 1000.0} seconds")
}
/*
    output:
        Weather forecast
        Sunny 30°C
        Have a good day!
        Execution time: 1.114 seconds
 */

 suspend fun getWeatherReport() = coroutineScope {
    val forecast = async { getForecast() }
    val temperature = async { getTemperature() }
    "${forecast.await()} ${temperature.await()}"
}

fun fifth_main() {
    val time = measureTimeMillis {
        runBlocking {
            println("Weather forecast")
            println(getWeatherReport())
            println("Have a good day!")
        }
    }
    println("Execution time: ${time / 1000.0} seconds")
}
/*
    output:
        Weather forecast
        Sunny 30°C
        Have a good day!
        Execution time: 1.129 seconds

    The output is the same, but there are some noteworthy takeaways here. 
    As mentioned earlier, coroutineScope() will only return once all its work, 
    including any coroutines it launched, have completed.

    With coroutineScope(), even though the function is internally doing work concurrently, 
    it appears to the caller as a synchronous operation because coroutineScope won't return until all work is done.

    The key insight here for structured concurrency is that you can take multiple concurrent operations 
    and put it into a single synchronous operation, where concurrency is an implementation detail. 
    The only requirement on the calling code is to be in a suspend function or coroutine. 
    Other than that, the structure of the calling code doesn't need to take into account the concurrency details.
 */

suspend fun getForecast(): String {
    delay(1000)
    return "Sunny"
}

suspend fun getTemperature(): String {
    delay(500)
    throw AssertionError("Temperature is invalid")
    return "30\u00b0C"
}

suspend fun getWeatherReport() = coroutineScope {
	val forecast = async { getForecast() }
    val temperature = async {
        try {
            getTemperature()
        } catch (e: AssertionError) {
            println("Caught exception $e")
            "{ No temperature found }"
        }
    }
    "${forecast.await()} ${temperature.await()}"
}

fun sixth_main() {
    val time = measureTimeMillis {
        runBlocking {
            println("Weather forecast")
            
            println(getWeatherReport())
            
            println("Have a good day!")
        }
    }
    println("Execution time: ${time / 1000.0} seconds")
}
/*
    output:
        Weather forecast
        Caught exception java.lang.AssertionError: Temperature is invalid
        Sunny { No temperature found }
        Have a good day!
        Execution time: 1.123 seconds
 */

suspend fun getWeatherReport() = coroutineScope {
    val forecast = async { getForecast() }
    val temperature = async { getTemperature() }
    
    delay(200)
    temperature.cancel()

    "${forecast.await()}"
}

fun seventh_main() {
    val time = measureTimeMillis {
        runBlocking {
            println("Weather forecast")
            
            println(getWeatherReport())
            
            println("Have a good day!")
        }
    }
    println("Execution time: ${time / 1000.0} seconds")
}
/*
    output:
        Weather forecast
        Sunny
        Have a good day!
        Execution time: 1.109 seconds
    
    What you've learned here is that a coroutine can be cancelled, 
    but it won't affect other coroutines in the same scope 
    and the parent coroutine will not be cancelled.
 */