package com.example.kotlinlearning.kotlinFlows

import com.example.kotlinlearning.kotlinFlows.commonModule.TAG
import com.example.kotlinlearning.kotlinFlows.commonModule.producer
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main()  {
    startWithBasicFlows()
}

fun startWithBasicFlows() {

   // TODO:- only use the run blocking and job here to run this code because without this it not print anything that's why.

    runBlocking {  // ->> Here this.
        val job = GlobalScope.launch {
            /**
             * Here this is is used to collect the values come from the flows.
             */
            val data: Flow<Int> = producer()
            data.collect { // If remove this collect then it not produce anything ( Because this is the cold flows)
                println("$TAG: Received value: $it")
            }
        }

        // When multiple consumers are there to consume the same producer.
        val job2 = GlobalScope.launch {
            val data: Flow<Int> = producer()
            data.collect {
                println("$TAG: Received value 1: $it")
            }
        }
        job.join()   // ->> Here this
        job2.join()
    }

    // Here for the multiple consumers it produce the value one by one means for con1 then con2.
}