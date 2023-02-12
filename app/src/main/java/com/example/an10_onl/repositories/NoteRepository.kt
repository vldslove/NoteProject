package com.example.an10_onl.repositories

import androidx.core.content.ContentProviderCompat.requireContext
import com.example.an10_onl.db.NoteData
import com.example.an10_onl.db.UserData
import com.example.an10_onl.model.Note
import okhttp3.internal.notifyAll

class NoteRepository {


    suspend fun getListNotes(): ArrayList<Note> {
        return NoteData.db.noteDao().selectAllNote() as ArrayList<Note>
    }

    suspend fun addNote(note: Note) {
        NoteData.db.noteDao().addNote(note)
    }

    suspend fun deleteNote(note: Note) {
        NoteData.db.noteDao().deleteNote(note)
    }

    fun deleteList(){
        NoteData.db.clearAllTables()
    }

    suspend fun getListSize(): Int {
        return NoteData.db.noteDao().selectAllNote().size
    }

}