package com.example.an10_onl

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        val loginFromSignup = findViewById<TextView>(R.id.loginFromSignup)
        loginFromSignup.setOnClickListener() {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.signupButton).setOnClickListener() {
            if (validate()) {

            }
        }

    }

    private fun validate(): Boolean {
        val isEmailValid = validateEmail()
        val isPasswordValid = validatePassword()
        val isFirstNameValid = validateFirstName()
        val isLastNameValid = validateLastName()

        return isEmailValid == null && isPasswordValid == null && isFirstNameValid == null && isLastNameValid == null
    }

    private fun validateEmail(): String? {
        val emailInputLayout = findViewById<TextInputLayout>(R.id.emailSignup)
        emailInputLayout.editText?.let {
            val result = EmailValidator.validateEmail(it.text.toString())
            return when (result) {
                is Invalid -> {
                    emailInputLayout.error = this.getString(result.errorText)
                    this.getString(result.errorText)
                }
                else -> {
                    emailInputLayout.error = null
                    null
                }
            }
        } ?: return null
    }

    private fun validatePassword(): String? {
        val passwordInputLayout = findViewById<TextInputLayout>(R.id.passwordSignup)
        passwordInputLayout.editText?.let {
            val result = validatePassword(it.text.toString())
            return when (result) {
                is Invalid -> {
                    passwordInputLayout.error = this.getString(result.errorText)
                    this.getString(result.errorText)
                }
                else -> {
                    passwordInputLayout.error = null
                    null
                }
            }
        } ?: return null
    }

    private fun validateFirstName(): String? {
        val firstNameInputLayout = findViewById<TextInputLayout>(R.id.firstNameSignup)
        firstNameInputLayout.editText?.let {
            val result = validateFirstName(it.text.toString())
            return when (result) {
                is Invalid -> {
                    firstNameInputLayout.error = this.getString(result.errorText)
                    this.getString(result.errorText)
                }
                else -> {
                    firstNameInputLayout.error = null
                    null
                }
            }
        } ?: return null
    }

    private fun validateLastName(): String? {
        val lastNameInputLayout = findViewById<TextInputLayout>(R.id.lastNameSignup)
        lastNameInputLayout.editText?.let {
            val result = validateLastName(it.text.toString())
            return when (result) {
                is Invalid -> {
                    lastNameInputLayout.error = this.getString(result.errorText)
                    this.getString(result.errorText)
                }
                else -> {
                    lastNameInputLayout.error = null
                    null
                }
            }
        } ?: return null
    }

}