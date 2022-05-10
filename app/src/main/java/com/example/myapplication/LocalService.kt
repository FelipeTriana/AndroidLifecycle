package com.example.myapplication

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.Bundle
import android.os.IBinder
import android.widget.Toast
import java.util.*

class LocalService: Service() {

    private val binder = LocalBinder()

    private val mGenerator = Random()


    val randomNumber: Int
        get() = mGenerator.nextInt(100)

    inner class LocalBinder : Binder() {
        // Return this instance of LocalService so clients can call public methods
        fun getService(): LocalService = this@LocalService
    }

    override fun onCreate() {
        super.onCreate()
        Toast.makeText(this, "OnCreate Service", Toast.LENGTH_SHORT).show()
        // El servicio esta creado

    }

    override fun onBind(intent: Intent?): IBinder? {
        Toast.makeText(this, "OnBind Service", Toast.LENGTH_SHORT).show()
        return binder;
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Toast.makeText(this, "OnUnbind Service", Toast.LENGTH_SHORT).show()
        return super.onUnbind(intent)
    }

    override fun onRebind(intent: Intent?) {
        super.onRebind(intent)
        Toast.makeText(this, "OnRebind Service", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "Destroy Service", Toast.LENGTH_SHORT).show()
    }


}