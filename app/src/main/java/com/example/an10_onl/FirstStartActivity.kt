package com.example.an10_onl

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import com.example.an10_onl.databinding.ActivityMainBinding
import org.w3c.dom.Text

class FirstStartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.discover_the_platform)
        button.setOnClickListener() {
            val intent = Intent(this, SecondPage::class.java)
            startActivity(intent)
        }
        val login = findViewById<TextView>(R.id.login)
        login.setOnClickListener() {
            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
        }

    }
}