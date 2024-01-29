package com.example.homework20.domain.usecase

import javax.inject.Inject

class UpdateUserOnCheckUseCase@Inject constructor(
    private val updateUserUseCase: UpdateUserUseCase,
    private val checkUserOnEmailUseCase:CheckUserOnEmailUseCase
) {
    suspend operator fun invoke(email:String): Boolean{
        val user = checkUserOnEmailUseCase(email)

        user?.let {
            updateUserUseCase(it)
            return true
        }
        return false  // if user is null
    }
}