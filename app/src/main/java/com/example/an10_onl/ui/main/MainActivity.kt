package com.example.an10_onl.ui.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.an10_onl.R
import com.example.an10_onl.navigation.BottomNavigationFragment
import com.example.an10_onl.repositories.SharedPreferencesRepository
import com.example.an10_onl.ui.appInfo.FirstStartFragment
import com.example.an10_onl.ui.listNote.ListFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreferencesRepository = SharedPreferencesRepository(this)
        if (sharedPreferencesRepository.getUserName() != null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, ListFragment())
                .addToBackStack("")
                .commit()
            supportFragmentManager.beginTransaction()
                .add(R.id.navigation_bar, BottomNavigationFragment())
                .addToBackStack("")
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, FirstStartFragment())
                .commit()

        }

    }

}