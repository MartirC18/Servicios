package com.example.servicios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Variable to hold service class name
        val serviceClass = MyService::class.java


        // Initialize a new Intent instance
        val intent = Intent(applicationContext, serviceClass)


        // Button to start the service
        btnempezar.setOnClickListener{
            // If the service is not running then start it
            if (!isServiceRunning(serviceClass)) {
                // Start the service
                startService(intent)
            } else {
                toast("Servicio Funcionando.")
            }
        }


        // Button to stop the service
        btndetener.setOnClickListener{
            // If the service is not running then start it
            if (isServiceRunning(serviceClass)) {
                // Stop the service
                stopService(intent)
            } else {
                toast("Servicio Detenido.")
            }
        }


        // Get the service status
        btnstatus.setOnClickListener{
            if (isServiceRunning(serviceClass)) {
                toast("Servicio corriendo.")
            } else {
                toast("Servicio Detenido.")
            }

        }
    }


    // Custom method to determine whether a service is running
    private fun isServiceRunning(serviceClass: Class<*>): Boolean {
        val activityManager = getSystemService(ACTIVITY_SERVICE) as ActivityManager

        // Loop through the running services
        for (service in activityManager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.name == service.service.className) {
                // If the service is running then return true
                return true
            }
        }
        return false
    }
}



// Extension function to show toast message
fun Context.toast(message:String){
    Toast.makeText(applicationContext,message,Toast.LENGTH_SHORT).show()
}





















