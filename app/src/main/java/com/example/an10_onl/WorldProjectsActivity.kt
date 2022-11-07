package com.example.an10_onl

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WorldProjectsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondpage)
        val skip2 = findViewById<TextView>(R.id.skip2)
        skip2.setOnClickListener() {
            val intent = Intent(this, MakeMoneyActivity::class.java)
            startActivity(intent)
        }
//        Handler().postDelayed({
//            val intent = Intent(this, ThirdPage::class.java)
//            startActivity(intent)
//        }, 2000)

    }
}