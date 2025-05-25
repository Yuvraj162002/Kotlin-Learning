package com.example.kotlinlearning.kotlinFlows.operator

import com.example.kotlinlearning.kotlinFlows.commonModule.TAG
import com.example.kotlinlearning.kotlinFlows.commonModule.producer
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    startWithFlowsEvent()
}

fun startWithFlowsEvent() {
    runBlocking {  // ->> Here this.
        val job = GlobalScope.launch {
            val data: Flow<Int> = producer()
            data
                .onStart {
                    emit(-1) // Emit value manually at the start so this emit first before the producer emit.
                    println("$TAG: Flow started, preparing to collect values...")
                }
                .onCompletion {
                    emit(6) // Manually emit a value when the flow completes.
                    println("$TAG: Flow completed, no more values to collect.")
                }
                .onEach {
                    println("$TAG: Processing value: $it")
                }
                .collect {
                    println("$TAG: Received value: $it")
                }
        }
        job.join()
    }
}
