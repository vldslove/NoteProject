package com.example.an10_onl

sealed class ValidationResult
object Valid: ValidationResult()
class Invalid(val errorText: Int) : ValidationResult()