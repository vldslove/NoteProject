package com.example.an10_onl

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout

class SignupFragment : Fragment() {
    private var emailInputLayout: TextInputLayout? = null
    private var passwordInputLayout: TextInputLayout? = null
    private var firstNameInputLayout: TextInputLayout? = null
    private var lastNameInputLayout: TextInputLayout? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_signup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        emailInputLayout = view.findViewById(R.id.emailSignup)
        passwordInputLayout = view.findViewById(R.id.passwordSignup)
        firstNameInputLayout = view.findViewById(R.id.firstNameSignup)
        lastNameInputLayout = view.findViewById(R.id.lastNameSignup)

        view.findViewById<TextView>(R.id.loginFromSignup).setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment())
                .commit()
        }
        view.findViewById<Button>(R.id.signupButton).setOnClickListener{
            if (validate()) {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.container, ListFragment())
                    .commit()
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
        emailInputLayout?.editText?.let {
            val result = EmailValidator.validateEmail(it.text.toString())
            return when (result) {
                is Invalid -> {
                    emailInputLayout?.error = this.getString(result.errorText)
                    this.getString(result.errorText)
                }
                else -> {
                    emailInputLayout?.error = null
                    null
                }
            }
        } ?: return null
    }

    private fun validatePassword(): String? {
        passwordInputLayout?.editText?.let {
            val result = validatePassword(it.text.toString())
            return when (result) {
                is Invalid -> {
                    passwordInputLayout?.error = this.getString(result.errorText)
                    this.getString(result.errorText)
                }
                else -> {
                    passwordInputLayout?.error = null
                    null
                }
            }
        } ?: return null
    }

    private fun validateFirstName(): String? {
        firstNameInputLayout?.editText?.let {
            val result = validateFirstName(it.text.toString())
            return when (result) {
                is Invalid -> {
                    firstNameInputLayout?.error = this.getString(result.errorText)
                    this.getString(result.errorText)
                }
                else -> {
                    firstNameInputLayout?.error = null
                    null
                }
            }
        } ?: return null
    }

    private fun validateLastName(): String? {
        lastNameInputLayout?.editText?.let {
            val result = validateLastName(it.text.toString())
            return when (result) {
                is Invalid -> {
                    lastNameInputLayout?.error = this.getString(result.errorText)
                    this.getString(result.errorText)
                }
                else -> {
                    lastNameInputLayout?.error = null
                    null
                }
            }
        } ?: return null
    }


}