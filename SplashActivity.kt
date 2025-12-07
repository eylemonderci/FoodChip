package com.example.foodchip

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val btnContinue = findViewById<Button>(R.id.btnContinue)
        btnContinue.setOnClickListener {
            //Intent ile MainActivty'e geçiş
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() //Geri tuşuna basınca tekrar splash'e dönmesin diye activity'i öldürdük.

        }

    }
}