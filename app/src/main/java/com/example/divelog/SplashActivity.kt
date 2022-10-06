package com.example.divelog

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()

        val intent = Intent(this, MainActivity::class.java)

        val runnable = Runnable {
            startActivity(intent)
            finish()
        }
        val handler = Handler()

        handler.postDelayed(runnable, 1000)
    }
}