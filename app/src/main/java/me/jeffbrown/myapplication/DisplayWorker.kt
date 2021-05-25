package me.jeffbrown.myapplication

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class DisplayWorker(context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {
    override fun doWork(): Result {
        //Do some sort of work
        for (i in 1..10) {
            Log.d("Deferred", "doWork: $i ")
        }
        //Indicate if work was returned succesfully, can also return failure and retry
        return Result.success()
    }
}