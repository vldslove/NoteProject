package com.example.an10_onl.ui.listNote

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.an10_onl.model.Note
import com.example.an10_onl.repositories.NoteRepository
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {

    private val repository = NoteRepository()

    val listNote = MutableLiveData<ArrayList<Note>>()

    fun getList() {
        viewModelScope.launch {
            listNote.value = repository.getListNotes()
        }
    }

    fun deleteNote(id: Int, title: String, message: String, date: String){
        viewModelScope.launch {
            repository.deleteNote(Note(id, title, message, date))
        }
    }

}