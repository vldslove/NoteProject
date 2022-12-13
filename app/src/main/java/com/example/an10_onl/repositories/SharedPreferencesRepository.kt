package com.example.an10_onl.repositories

import android.content.Context
import androidx.core.content.edit

private const val USER_PREFERENCES = "user_preferences"
private const val GLOBAL_PREFERENCES = "global_preferences"
private const val USER_NAME = "user_name"

private const val PASSWORD = "password"


class SharedPreferencesRepository(private val context: Context){
    private val userPreferences =
        context.getSharedPreferences(USER_PREFERENCES, Context.MODE_PRIVATE)

    private val globalPreferences =
        context.getSharedPreferences(GLOBAL_PREFERENCES, Context.MODE_PRIVATE)

    fun setUserName(userName: String) {
        userPreferences.edit {
            putString(USER_NAME, userName)
        }
    }
    fun setUserPassword(password: String) {
        userPreferences.edit {
            putString(password, password)
        }
    }
    fun getUserName(): String? {
        return userPreferences.getString(USER_NAME, null)
    }

    fun logout() {
        userPreferences.edit{
            clear()
        }
    }
}