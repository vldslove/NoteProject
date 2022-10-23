package com.example.an10_onl

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SixthPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sixthpage)
        val skip = findViewById<TextView>(R.id.skip6)
        skip.setOnClickListener(){
            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
        }
        Handler().postDelayed({
            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
        }, 10000)
    }
}