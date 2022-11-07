package com.example.an10_onl

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LevelUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifthpage)
        val skip2 = findViewById<TextView>(R.id.skip5)
        skip2.setOnClickListener() {
            val intent = Intent(this, ProgressActivity::class.java)
            startActivity(intent)
        }
//        Handler().postDelayed({
//            val intent = Intent(this, SixthPage::class.java)
//            startActivity(intent)
//            finish()
//        }, 2000)
    }
}