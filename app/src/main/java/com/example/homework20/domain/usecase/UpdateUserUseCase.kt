package com.example.homework20.domain.usecase

import com.example.homework20.domain.model.User
import com.example.homework20.domain.repository.DataBaseRepository
import javax.inject.Inject

class UpdateUserUseCase @Inject constructor(
    private val dataBaseRepository: DataBaseRepository
) {
    suspend operator fun invoke(user: User){
        dataBaseRepository.updateUser(user)
    }
}