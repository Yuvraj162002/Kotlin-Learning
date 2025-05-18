package com.example.kotlinlearning.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout


fun main(){
    startWithJobWaitingCancellationManually()
    startWithJobWaitingCancellationAutomatically()
}

fun startWithJobWaitingCancellationAutomatically() {

    val TAG = "JobWaitingCancellationFunction"

    val automaticallyJob  = GlobalScope.launch(Dispatchers.Default) {
        withTimeout(3000) { /// -> this is the automatically cancellation of the job
            repeat(10){
                println("$TAG: coroutines executed inside the threads working.... $it")
                delay(1000) // Simulating some work
            }
        }
    }

    runBlocking {
        automaticallyJob.join()
        println("$TAG: coroutines executed other then the threads finished.....")
    }
}


fun startWithJobWaitingCancellationManually() {

    val TAG = "JobWaitingCancellationFunction"

    // Example of the job.join() -> This waits for the coroutine to finish before proceeding with the next line of code.

    val job = GlobalScope.launch(Dispatchers.Default) {
            repeat(10) {
                println("$TAG: coroutines executed inside the threads working.... $it")
                delay(1000) // Simulating some work
            }
        }

    // use the runBlocking because the join is a suspending function.
    runBlocking {

        /**
         * here this is used for to wait for the coroutine to finish before proceeding with the next line of code.
      ---->  job.join() <---
        */

        // this is doing that for 2 sec till the iteration 0,1,2 complete on bg thread and then it cancel the job.
        delay(2000)
        job.cancel() // Wait for the coroutine to finish ----> this the manually cancellation of the job.
        println("$TAG: coroutines executed inside the threads finished.....")
    }
}
