package com.example.homework20.domain.usecase.validations

import javax.inject.Inject

class ValidateEmailUseCase @Inject constructor() {

    operator fun invoke(email:String):Boolean{
        val emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$".toRegex()
        return email.matches(emailRegex)
    }
}