package me.jeffbrown.myapplication

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log


fun createAlarm(context: Context) {
    //Get instance of AlarmManager

    //system service and can be retrieved
    val alarm = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    //Intent
    val intent = Intent(context, AlarmReceiver::class.java).let { intent ->
        intent.action = "FOO_STRING"
        intent.putExtra("KEY_FOO_STRING", "AlarmManager Demo")
        PendingIntent.getBroadcast(context, 0, intent, 0)
    }

    //Alarm time

    val ALARM_DELAY_IN_SECOND = 10
    val alarmTimeAtUTC = System.currentTimeMillis() + ALARM_DELAY_IN_SECOND * 1_000L


    //Set with system Alarm Service
    //Other possible funl setExact() , setRepeating(), setWindow()

    alarm.setRepeating(
        AlarmManager.RTC_WAKEUP,
        alarmTimeAtUTC,
        1000 * 60 * 1,
        intent
    )
    Log.d("Exact", "createAlarm: Alarm has been created ")
}