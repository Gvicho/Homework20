package com.example.homework20.domain.usecase

import javax.inject.Inject

class DeleteSafeUserUseCase @Inject constructor(
    private val deleteUserUseCase: DeleteUserUseCase,
    private val checkUserOnAllInfoUseCase: CheckUserOnAllInfoUseCase
) {
    suspend operator fun invoke(email: String, firstName: String, lastName: String, age: Int): String?{
        return if(checkUserOnAllInfoUseCase(
                email = email,
                firstName = firstName,
                lastName = lastName,
                age = age
        ) == null){
            null
        }else{
            val deletion = deleteUserUseCase(
                email = email,
                firstName = firstName,
                lastName = lastName,
                age = age)
            if(deletion){
                email
            }else{
                null
            }
        }
    }
}