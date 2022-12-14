package com.example.an10_onl.repositories

import com.example.an10_onl.db.NoteData
import com.example.an10_onl.model.User

class UserRepository {

    suspend fun addUser(user: User) {
        NoteData.db.userDao().addUser(user)
    }

    suspend fun getAllUsers() : ArrayList<User> {
        return NoteData.db.userDao().getAllUsers() as ArrayList<User>
    }

    suspend fun getUserEmail(email: String): ArrayList<String>{
        return NoteData.db.userDao().selectUserEmail(email) as ArrayList<String>
    }

    suspend fun getUserPassword(password: String): ArrayList<String>{
        return NoteData.db.userDao().selectUserPassword(password) as ArrayList<String>
    }

    suspend fun deleteUser(user: User){
        NoteData.db.userDao().userDelete(user)
    }

    suspend fun deleteAllUsers(list: List<User>){
        NoteData.db.userDao().deleteAllUsers(list)
    }
}