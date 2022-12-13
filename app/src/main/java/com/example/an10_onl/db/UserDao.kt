package com.example.an10_onl.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.an10_onl.model.User

@Dao
interface UserDao {

    @Insert
    fun addUser(user: User)

    @Query ("SELECT * FROM user")
    fun getAllUsers(): List<User>

    @Query("SELECT email FROM User WHERE email LIKE :email")
    fun selectUserEmail(email: String): List<String>

    @Query("SELECT password FROM User WHERE password LIKE :password")
    fun selectUserPassword(password: String): List<String>

    @Delete
    fun userDelete(user: User)

    @Delete
    fun deleteAllUsers(list: List<User>)
}