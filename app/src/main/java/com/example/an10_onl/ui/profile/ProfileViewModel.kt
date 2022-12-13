package com.example.an10_onl.ui.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.an10_onl.model.User
import com.example.an10_onl.repositories.NoteRepository
import com.example.an10_onl.repositories.SharedPreferencesRepository
import com.example.an10_onl.repositories.UserRepository
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {

    val repository = NoteRepository()
    val userRepository = UserRepository()

    val listUsers = MutableLiveData<ArrayList<User>>()

    companion object {
        const val none = "0 note"
    }

    fun getSize(): Int {
        return repository.getListSize()
    }

    fun deleteNotes() {
        repository.deleteList()
    }


    fun getUsers(){
        listUsers.value = userRepository.getAllUsers()
    }


}