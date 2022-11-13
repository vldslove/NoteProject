package com.example.an10_onl

fun validateLastName(lastName: String): ValidationResult {
    return when {
        lastName.isBlank() -> {
            Invalid(R.string.lastName_blank)
        }
        lastName.length < 3 -> {
            Invalid(R.string.lastName_blank)
        }
        lastName.length > 255 -> {
            Invalid(R.string.lastName_blank)
        }
        else -> Valid
    }
}