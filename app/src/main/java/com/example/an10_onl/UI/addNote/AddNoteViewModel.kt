package com.example.an10_onl.UI.addNote

import androidx.lifecycle.ViewModel
import com.example.an10_onl.model.NoteList
import com.example.an10_onl.repositories.NoteRepository

class AddNoteViewModel : ViewModel(){
    private val repository = NoteRepository()


    fun addNote(title: String, message: String, date: String){
        repository.addNote(NoteList(title,message,date))
    }
}