package com.example.an10_onl

fun validateTitle(title: String): ValidationResult {
    return when {
        title.isBlank() -> {
            Invalid(R.string.firstName_blank)
        }
        else -> Valid
    }
}