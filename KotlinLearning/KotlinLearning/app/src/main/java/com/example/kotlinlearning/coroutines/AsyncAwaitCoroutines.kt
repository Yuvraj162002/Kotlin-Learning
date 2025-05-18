package com.example.kotlinlearning.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

fun main(){
    startWithAsyncAwaitCoroutines()
}


fun startWithAsyncAwaitCoroutines() {
    val TAG = "AsyncAwaitCoroutinesFunction"

    GlobalScope.launch(Dispatchers.IO) {
        val time = measureTimeMillis {

            /**
             * Doing like this means that it print the overall printSt. after the 6 sec, which is not the good approach to do that., to handle this case we use the async await call.
             */
            val networkCall1 = doNetworkCall1forAsyncAwait()
            val networkCall2 = doNetworkCall2forAsyncAwait()
            println("$TAG network1 call will print  $networkCall1")
            println("$TAG network2 call will print  $networkCall2")


            /**
             * Async call approach is used to run the coroutines in parallel and it will not block the main thread and here final result will be printed after the 3 sec.
             */
            val networkCallAsync1 = async { doNetworkCall1forAsyncAwait() }
            val networkCallAsync2 = async { doNetworkCall2forAsyncAwait() }
            println("$TAG network1 call will print  ${networkCallAsync1.await()}") // --> Here using await to collect the async call.
            println("$TAG network2 call will print  ${networkCallAsync2.await()}")
        }
        println("$TAG Total time taken: $time ms")
    }
}

suspend fun doNetworkCall1forAsyncAwait():String {
    delay(300)
    return "Network Call 1"
}

suspend fun doNetworkCall2forAsyncAwait():String {
    delay(300)
    return "Network Call 2"
}
