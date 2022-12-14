package com.example.an10_onl.ui.addNote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.an10_onl.model.Note
import com.example.an10_onl.repositories.NoteRepository
import kotlinx.coroutines.launch

class AddNoteViewModel : ViewModel(){
    private val repository = NoteRepository()


    fun addNote(id: Int, title: String, message: String, date: String){
        viewModelScope.launch {
            repository.addNote(Note(id, title, message, date))
        }
    }
}