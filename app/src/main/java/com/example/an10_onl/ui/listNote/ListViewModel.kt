package com.example.an10_onl.ui.listNote

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.an10_onl.model.Note
import com.example.an10_onl.repositories.NoteRepository

class ListViewModel : ViewModel() {

    private val repository = NoteRepository()

    val listNote = MutableLiveData<ArrayList<Note>>()

    fun getList() {
        listNote.value = repository.getListNotes()
    }

    fun deleteNote(id: Int, title: String, message: String, date: String){
        repository.deleteNote(Note(id,title,message,date))
    }



}