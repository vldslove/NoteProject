package com.example.an10_onl

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FifthPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifthpage)
        val skip2 = findViewById<TextView>(R.id.skip5)
        skip2.setOnClickListener() {
            val intent = Intent(this, SixthPage::class.java)
            startActivity(intent)
        }
        Handler().postDelayed({
            val intent = Intent(this, SixthPage::class.java)
            startActivity(intent)
        }, 10000)
    }
}