package com.example.kotlinlearning.coroutines

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    startWithRunBlocking()
}

fun startWithRunBlocking() {
    val TAG = "RunBlockingFunction"

    // This will block the main thread till the coroutines is executed.

    Log.e(TAG, "coroutines executed outside the threads starting....")
    runBlocking {
        Log.e(TAG, "coroutines executed inside the threads.")

        /**
         * Here this not block this both the bg1 and bg2 thread because this is launched in the bg thread, and runblocking is used to block the main thread only.
         */
        launch(Dispatchers.IO) {
            delay(3000)
            Log.e(TAG, "coroutines executed inside the bg1 thread.")
        }

        launch(Dispatchers.IO) {
            delay(3000)
            Log.e(TAG, "coroutines executed inside the bg2 thread.")
        }

        delay(5000)
        Log.e(TAG, "end of the run blocking.")
    }
    Log.e(TAG, "coroutines executed outside the threads end....")
}
