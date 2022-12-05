package com.example.an10_onl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout
import org.w3c.dom.Text

class LoginFragment : Fragment() {

    private var passwordInputLayout: TextInputLayout? = null
    private var emailInputLayout: TextInputLayout? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        passwordInputLayout = view.findViewById(R.id.passwordField)
        emailInputLayout = view.findViewById(R.id.emailField)
        view.findViewById<TextView>(R.id.to_signup).setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, SignupFragment())
                .commit()
        }

        view.findViewById<Button>(R.id.login_button).setOnClickListener{
            if (validate()) {
                parentFragmentManager.beginTransaction()
                    .add(R.id.container, ListFragment())
                    .commit()
            }
        }
    }

    private fun validate(): Boolean {
        val isEmailValid = validateEmail()
        val isPasswordValid = validatePassword()

        return isEmailValid == null && isPasswordValid == null
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


}
