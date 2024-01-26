package com.example.homework20.domain.usecase

import com.example.homework20.domain.model.User
import com.example.homework20.domain.repository.DataBaseRepository
import javax.inject.Inject

class CheckUserOnAllInfoUseCase @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
) {
    suspend operator fun invoke(email: String, firstName: String, lastName: String, age: Int): User?{
        return dataBaseRepository.findUser(
            email = email,
            firstName = firstName,
            lastName = lastName,
            age = age
        )
    }
}