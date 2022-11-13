package com.example.an10_onl

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class FirstStartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.discover_the_platform)
        button.setOnClickListener() {
            val intent = Intent(this, WorldProjectsActivity::class.java)
            startActivity(intent)
        }
        val login = findViewById<TextView>(R.id.login)
        login.setOnClickListener() {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }

    }
}