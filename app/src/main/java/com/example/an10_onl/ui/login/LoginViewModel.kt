package com.example.an10_onl.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.an10_onl.repositories.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val repository = UserRepository()

    suspend fun getUserEmail(email: String): ArrayList<String>{
        return repository.getUserEmail(email)
    }
    suspend fun getUserPassword(password: String): ArrayList<String>{
        return repository.getUserPassword(password)
    }
}