package com.example.ludditeinstaller

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var logDisplay: LogDisplay

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val logTextView = findViewById<TextView>(R.id.log_text_view)
        logDisplay = LogDisplay(this, logTextView)

        val whatsappButton = findViewById<Button>(R.id.btn_whatsapp)
        whatsappButton.setOnClickListener { v: View? ->
            logDisplay.log("MainActivity", "WhatsApp install button clicked")
            val appStore = AppStore(logDisplay)
            appStore.downloadAndInstallApk(
                this,
                "https://scontent.whatsapp.net/v/t61.25591-34/10000000_1970768216771235_41723970822000500_n.apk/WhatsApp.apk?ccb=1-7&_nc_sid=c49adc&_nc_ohc=u9etM8GIfIQQ7kNvgFekAK4&_nc_zt=3&_nc_ht=scontent.whatsapp.net&_nc_gid=AKHGXCfvpKZ1237Zq0Xs5kW&oh=01_Q5AaIGUofr6QbnvMxDVrTOAUzp7cD0C0ZiIv22leRtpHBFhE&oe=6794C9F8",
                "whatsapp.apk"
            )
        }

        // Optional: Add a clear logs button
        val clearButton = findViewById<Button>(R.id.btn_clear_logs)
        clearButton.setOnClickListener {
            logDisplay.clear()
        }
    }
}