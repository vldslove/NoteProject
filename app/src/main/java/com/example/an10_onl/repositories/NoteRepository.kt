package com.example.an10_onl.repositories

import com.example.an10_onl.db.NoteData
import com.example.an10_onl.db.UserData
import com.example.an10_onl.model.Note

class NoteRepository {

    fun getListNotes(): ArrayList<Note> {
        return NoteData.listNote
    }

    fun addNote(note: Note) {
        NoteData.listNote.add(note)
    }

    fun deleteNote(note: Note) {
        NoteData.listNote.remove(note)
    }

    fun deleteList(){
        NoteData.listNote.clear()
    }

    fun getListSize(): Int {
        return NoteData.listNote.size
    }

    fun getUser() : String {
        return UserData.user.toString()
    }
}