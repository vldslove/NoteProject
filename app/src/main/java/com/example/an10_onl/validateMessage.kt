package com.example.an10_onl

fun validateMessage(message: String): ValidationResult {
    return when {
        message.isBlank() -> {
            Invalid(R.string.firstName_blank)
        }
        else -> Valid
    }
}