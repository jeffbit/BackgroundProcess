package me.jeffbrown.myapplication

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private lateinit var result: String

    //used to schedule periodic work
    private val uploadWorkRequestPeriodicly =
        PeriodicWorkRequestBuilder<DisplayWorker>(15, TimeUnit.MINUTES).build()


    //deferred constraints based on conditions entered
    private val constraints = Constraints.Builder()
        .setRequiresCharging(true)
        .build()


    //used to schedule one time non repeating work
    private val uploadWorkRequest: WorkRequest =
//        sets initial delay of 10 seconds after it has been enqueued
        OneTimeWorkRequestBuilder<DisplayWorker>().setInitialDelay(10, TimeUnit.SECONDS)
            .addTag("OneTimeWork")
            .setConstraints(constraints).build()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Use workmanager when you want to deferrer a task that is long running or that doesnt have to be returned immediatly or at an exact time

        val deferredBtn = findViewById<Button>(R.id.deferred_task_btn)
        deferredBtn.setOnClickListener {
            Log.d("Deferred", "onCreate: Deferred Button clicked. Work enqueued.....")

            WorkManager.getInstance(this)
//                .enqueue(uploadWorkRequest)
                .enqueue(uploadWorkRequest)
            Log.d(
                "Deferred",
                "onCreate: ${WorkManager.getInstance(this).getWorkInfosByTag("OneTimeWork")}"
            )

        }


        //Use alarm manager when you want to have something happen at an exact time.
        //this alarm is set after 10 seconds of button being clicked, then repeats the alarm every minute after.

        val exactBtn = findViewById<Button>(R.id.exact_task_btn)
        exactBtn.setOnClickListener {
            Log.d("Exact", "onCreate: Exact button clicked....")
            createAlarm(this.applicationContext)

        }


        //This is ran on the Coroutine Dispatcher.IO thread and then delayed with handler 10 sec to wait in response back to mainthread
        val immediateBtn = findViewById<Button>(R.id.immediate_task_btn)
        immediateBtn.setOnClickListener {
            Log.d("Immediate", "onCreate: immediate coroutine started ")
            CoroutineScope(Dispatchers.Main).launch {
                result = returnFromBackGroundThread()

            }
            val handler = Handler()
            handler.postDelayed(Runnable {
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
            }, 10000)

        }


    }
}