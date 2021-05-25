package me.jeffbrown.myapplication

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

var result = "test"
suspend fun returnFromBackGroundThread(): String {
    return withContext(Dispatchers.IO) {
        try {
            Log.d("IMMEDIATE", "returnFromBackGroundThread: try.....")
            result = "successful"
            result

        } catch (e: java.lang.Exception) {
            Log.d("IMMEDIATE", "returnFromBackGroundThread: catch.....")
            result = e.toString()
            result
        }

    }


}