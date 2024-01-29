package com.example.homework20.domain.usecase

import com.example.homework20.domain.model.User
import com.example.homework20.domain.usecase.validations.ValidateEmailUseCase
import javax.inject.Inject

class InsertSafeUserUseCase @Inject constructor(
    private val insertUserUseCase: InsertUserUseCase,
    private val checkUserOnEmailUseCase:CheckUserOnEmailUseCase,
    private val validateEmailUseCase: ValidateEmailUseCase
) {
    suspend operator fun invoke(user: User):User?{
        return if(!validateEmailUseCase(user.email)){
            null
        } else if(checkUserOnEmailUseCase(user.email) == null){
            insertUserUseCase(user)
            user
        }else{
            null
        }
    }
}