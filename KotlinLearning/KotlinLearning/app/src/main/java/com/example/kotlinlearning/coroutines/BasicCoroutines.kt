package com.example.kotlinlearning.coroutines

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


fun main() {

    startWithCoroutines()
}

fun startWithCoroutines() {

    val TAG = "CoroutinesFunction"

    GlobalScope.launch {
        Log.e(TAG,"coroutines executed inside the threads.")
    }
    // This blocks executed first means as the coroutines are launched as "launch" not blocked the main thread so that inside coroutines work in bg till then this outside code executed.
   Log.e(TAG,"coroutines executed outside the threads.")
}
