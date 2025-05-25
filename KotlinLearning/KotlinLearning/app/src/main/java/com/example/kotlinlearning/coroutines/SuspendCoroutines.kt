package com.example.kotlinlearning.coroutines

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    suspendCoroutineFunction()
}

fun suspendCoroutineFunction() {
    val TAG = "SuspendCoroutines"

    GlobalScope.launch {
        val networkCall1 = doNetworkCall1()
        val networkCall2 = doNetworkCall2()

        // So here both will print after the 6sec because both are suspend function and they are executed one by one.
        println("$TAG: network1 call will print $networkCall1.....")
        Log.e(TAG, "network2 call will print  $networkCall2")

    }
}

private suspend fun doNetworkCall1(): String {
    // need to use suspend keyword with the function to make it suspend function and without this keyword we can not call this function inside the coroutine. and also no call delay in this function.
    delay(3000)
    return "Network Call 1"
}

private suspend fun doNetworkCall2(): String {
    delay(3000)
    return "Network Call 2"
}
