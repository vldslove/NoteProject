package com.example.an10_onl.UI.listNote

import android.provider.ContactsContract
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.an10_onl.db.NoteData
import com.example.an10_onl.model.NoteList
import com.example.an10_onl.repositories.NoteRepository

class ListViewModel : ViewModel() {

    private val repository = NoteRepository()

    val listNote = MutableLiveData<ArrayList<NoteList>>()

    fun getList() {
        listNote.value = repository.getListNotes()
    }

    fun deleteNote(title: String, message: String, date: String){
        repository.deleteNote(NoteList(title,message,date))
    }

}