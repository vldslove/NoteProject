package com.example.an10_onl.db

import android.content.Context
import androidx.room.Room



object NoteData {

    lateinit var db: AppDataBase

    fun initDB(context: Context) {
        db = Room.databaseBuilder(
            context,
            AppDataBase::class.java, "database-name"
        ).allowMainThreadQueries().build()
    }
}