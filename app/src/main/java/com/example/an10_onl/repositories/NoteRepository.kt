package com.example.an10_onl.repositories

import android.provider.ContactsContract
import com.example.an10_onl.db.NoteData
import com.example.an10_onl.model.NoteList

class NoteRepository {

    fun getListNotes(): ArrayList<NoteList> {
        return NoteData.listNote
    }

    fun addNote(note: NoteList) {
        NoteData.listNote.add(note)
    }

    fun deleteNote(note: NoteList) {
        NoteData.listNote.remove(note)
    }
}