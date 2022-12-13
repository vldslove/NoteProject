package com.example.an10_onl.ui.login

import androidx.lifecycle.ViewModel
import com.example.an10_onl.repositories.UserRepository

class LoginViewModel : ViewModel() {

    private val repository = UserRepository()

    fun getUserEmail(email: String): ArrayList<String>{
        return repository.getUserEmail(email)
    }
    fun getUserPassword(password: String): ArrayList<String>{
        return repository.getUserPassword(password)
    }
}