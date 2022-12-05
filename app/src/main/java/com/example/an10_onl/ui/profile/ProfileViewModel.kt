package com.example.an10_onl.ui.profile

import androidx.lifecycle.ViewModel
import com.example.an10_onl.repositories.NoteRepository

class ProfileViewModel : ViewModel() {

    val repository = NoteRepository()

    companion object {
        const val none = "0 note"
    }

    fun getSize(): Int {
        return repository.getListSize()
    }

    fun deleteNotes() {
        repository.deleteList()
    }

    fun getUser() : String{
       return repository.getUser()
    }

}