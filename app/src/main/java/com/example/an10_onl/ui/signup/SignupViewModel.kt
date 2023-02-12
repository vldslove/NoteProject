package com.example.an10_onl.ui.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.an10_onl.model.User
import com.example.an10_onl.repositories.UserRepository
import kotlinx.coroutines.launch

class SignupViewModel : ViewModel() {

    private val repository = UserRepository()


    fun addUser(email: String, password: String, firstName: String, lastName: String) {
        viewModelScope.launch {
            repository.addUser(User(email, password, firstName, lastName))
        }
    }
}