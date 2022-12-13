package com.example.an10_onl.db

import android.text.method.TextKeyListener.clear
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.an10_onl.model.Note

@Dao
interface NoteDao {

    @Insert
    fun addNote(note: Note)

    @Delete
    fun deleteNote(note: Note)

    @Query("SELECT * FROM Note")
    fun selectAllNote(): List<Note>

}