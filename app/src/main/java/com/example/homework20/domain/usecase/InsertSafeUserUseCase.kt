package com.example.homework20.domain.usecase

import com.example.homework20.domain.model.User
import javax.inject.Inject

class InsertSafeUserUseCase @Inject constructor(
    private val insertUserUseCase: InsertUserUseCase,
    private val checkUserOnEmailUseCase:CheckUserOnEmailUseCase
) {
    suspend operator fun invoke(user: User):User?{
        return if(checkUserOnEmailUseCase(user.email) == null){
            insertUserUseCase(user)
            user
        }else{
            null
        }
    }
}