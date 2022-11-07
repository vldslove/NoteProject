package com.example.an10_onl

fun validateFirstName(firstName: String): ValidationResult {
    return when {
        firstName.isBlank() -> {
            Invalid(R.string.firstName_blank)
        }
        firstName.length < 3 -> {
            Invalid(R.string.firstName_blank)
        }
        firstName.length > 255 -> {
            Invalid(R.string.firstName_blank)
        }
        else -> Valid
    }
}