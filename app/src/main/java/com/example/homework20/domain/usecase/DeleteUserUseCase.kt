package com.example.homework20.domain.usecase

import com.example.homework20.domain.repository.DataBaseRepository
import javax.inject.Inject

class DeleteUserUseCase @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
) {
    suspend operator fun invoke(email: String, firstName: String, lastName: String, age: Int):Boolean{
        return try {
            dataBaseRepository.deleteUser(
                email = email,
                firstName = firstName,
                lastName = lastName,
                age = age
            )
            true
        } catch (e: Exception) {
            false
        }

    }
}