package com.example.an10_onl

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ChatAndDevelopActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourthpage)
        val skip2 = findViewById<TextView>(R.id.skip4)
        skip2.setOnClickListener() {
            val intent = Intent(this, LevelUpActivity::class.java)
            startActivity(intent)
        }
//        Handler().postDelayed({
//            val intent = Intent(this, FifthPage::class.java)
//            startActivity(intent)
//            finish()
//        }, 2000)
    }
}