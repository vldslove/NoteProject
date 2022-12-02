package com.example.an10_onl.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.an10_onl.model.Note
import com.example.an10_onl.repositories.NoteRepository

class SearchViewModel : ViewModel() {

    private val repository = NoteRepository()

    val listNote = MutableLiveData<ArrayList<Note>>()

    val searchResult = MutableLiveData<ArrayList<Note>>()

    fun getList(){
        listNote.value = repository.getListNotes()
    }

    fun searchNote(searchText: String) {
        searchResult.value = repository.getListNotes().filter {
            it.title.contains(searchText) || it.message.contains(searchText)
        } as ArrayList<Note>
    }
}