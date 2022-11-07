package com.example.an10_onl

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val signup = findViewById<TextView>(R.id.to_signup)
        signup.setOnClickListener() {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
        findViewById<TextInputLayout>(R.id.passwordField)?.getStringText()
        findViewById<Button>(R.id.login_button).setOnClickListener() {
            if (validate()) {

            }
        }

    }

    private fun validate(): Boolean {
        val isEmailValid = validateEmail()
        val isPasswordValid = validatePassword()

        return isEmailValid == null && isPasswordValid == null
    }

    private fun validatePassword(): String? {
        val passwordInputLayout = findViewById<TextInputLayout>(R.id.passwordField)
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

    private fun validateEmail(): String? {
        val emailInputLayout = findViewById<TextInputLayout>(R.id.emailField)
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
}
