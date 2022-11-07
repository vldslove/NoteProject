package com.example.an10_onl

import java.util.regex.Matcher
import java.util.regex.Pattern

fun validatePassword(password: String): ValidationResult {
    return when {
        password.isBlank() -> {
            Invalid(R.string.password_blank)
        }
        password.length < 6 -> {
            Invalid(R.string.passwordLessThan6)
        }
        password.length > 50 -> {
            Invalid(R.string.passwordMoreThan50)
        }
        !password.matches(".*[A-Z].*".toRegex()) -> {
            Invalid(R.string.passwordUpperCase)
        }
        !password.matches(".*[a-z].*".toRegex()) -> {
            Invalid(R.string.passwordLowerCase)
        }
        !password.matches(".*[!@#$%^&*+=/?].*".toRegex()) -> {
            Invalid(R.string.passwordCharacter)
        }
        !password.matches(".*[0-9].*".toRegex()) -> {
            Invalid(R.string.passwordDigit)
        }

        else -> Valid
    }
}