package com.example.kotlinlearning.kotlinFlows.commonModule

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

val TAG = "KotlinFlows"

/**
 * Here this is the function which produces a flow of integers.
 */
fun producer() = flow<Int> {
    val list = listOf(1, 2, 3, 4, 5)
    list.forEach {
//        delay(1000)
        emit(it) // Emit each item in the list
        println("$TAG: Emitting the  value: $it")
    }
}