package com.example.servicios

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.Handler
import java.text.SimpleDateFormat
import java.util.*


class MyService : Service() {


        private lateinit var mHandler: Handler
        private lateinit var mRunnable: Runnable

        override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
        }override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {



            toast("Servicio Iniciado.")


            mHandler = Handler()
            mRunnable = Runnable {
                showFechaYhora()
            }
            mHandler.postDelayed(mRunnable, 5000)

            return Service.START_STICKY
        }

        override fun onDestroy() {
            super.onDestroy()
            toast("Servicio Parado.")
            mHandler.removeCallbacks(mRunnable)
        }


        private fun showFechaYhora() {

            val dateFormat = SimpleDateFormat("dd.LLLL.yyyy HH:mm:ss aaa z", Locale.getDefault())
            val date = Date()
            val fecha: String = dateFormat.format(date)

            toast("Fecha y Hora: $fecha")
            mHandler.postDelayed(mRunnable, 5000)
        }
    }



