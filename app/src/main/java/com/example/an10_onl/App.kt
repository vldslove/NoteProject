package com.example.an10_onl

import android.app.Application
import com.example.an10_onl.db.NoteData

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        NoteData.initDB(applicationContext)
    }
}