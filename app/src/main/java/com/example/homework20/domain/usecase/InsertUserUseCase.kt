package com.example.homework20.domain.usecase

import com.example.homework20.domain.model.User
import com.example.homework20.domain.repository.DataBaseRepository
import javax.inject.Inject

class InsertUserUseCase @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
) {
    suspend operator fun invoke(user: User){
        dataBaseRepository.insertUser(user)
    }
}