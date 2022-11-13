package com.example.an10_onl

import android.util.Patterns

object EmailValidator {
    fun validateEmail(email: String): ValidationResult {
        return when {
            Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                Valid
            }
            email.isBlank() -> {
                Invalid(R.string.email_blank)
            }
            else -> Invalid(R.string.email_invalid)
        }
    }
}