package com.example.an10_onl.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.an10_onl.utils.validation.EmailValidator
import com.example.an10_onl.utils.validation.Invalid
import com.example.an10_onl.R
import com.example.an10_onl.ui.signup.SignupFragment
import com.example.an10_onl.ui.listNote.ListFragment
import com.example.an10_onl.databinding.FragmentLoginBinding
import com.example.an10_onl.db.UserData
import com.example.an10_onl.navigation.BottomNavigationFragment
import com.google.android.material.textfield.TextInputLayout

class LoginFragment : Fragment() {

    private var passwordInputLayout: TextInputLayout? = null
    private var emailInputLayout: TextInputLayout? = null
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        passwordInputLayout = view.findViewById(R.id.passwordField)
        emailInputLayout = view.findViewById(R.id.emailField)
        binding.toSignup.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, SignupFragment())
                .commit()
        }

        binding.loginButton.setOnClickListener {
            if (validate()) {
                UserData.user = binding.emailFieldText.text.toString()
                parentFragmentManager.beginTransaction()
                    .add(R.id.container, ListFragment())
                    .addToBackStack("")
                    .commit()
                parentFragmentManager.beginTransaction()
                    .replace(R.id.navigation_bar, BottomNavigationFragment())
                    .addToBackStack("")
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
            val result = com.example.an10_onl.utils.validation.validatePassword(it.text.toString())
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
