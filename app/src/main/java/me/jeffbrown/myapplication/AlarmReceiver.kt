package me.jeffbrown.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class AlarmReceiver() : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
            Toast.makeText(context, "Alarm Received", Toast.LENGTH_LONG).show();
            Log.d("EXACT", "onReceive: Alarm received.... ")
        }
    }