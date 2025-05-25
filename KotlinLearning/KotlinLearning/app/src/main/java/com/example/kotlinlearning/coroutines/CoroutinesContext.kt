package com.example.kotlinlearning.coroutines

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun main() {
    startWithCoroutinesContext()
}

fun startWithCoroutinesContext() {
    val TAG = "CoroutinesContext"

    GlobalScope.launch(Dispatchers.IO) {
        Log.e(TAG, "coroutines executed inside the bg  thread.")
        val networkCall = doContextNetworkCall1()

        // Now need to show the result in the UI  so we need to switch the thread from bg to main.

        withContext(Dispatchers.Main) {
            Log.e(TAG, "coroutines executed inside the main thread.")
        }
    }
}


suspend fun doContextNetworkCall1(): String {
    // need to use suspend keyword with the function to make it suspend function and without this keyword we can not call this function inside the coroutine. and also no call delay in this function.
    delay(3000)
    return "Network Call 1"
}
