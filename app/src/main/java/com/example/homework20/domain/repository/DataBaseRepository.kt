package com.example.homework20.domain.repository

import com.example.homework20.domain.model.User

interface DataBaseRepository {
    suspend fun insertUser(user: User)
    suspend fun deleteUser(email: String, firstName: String, lastName: String, age: Int)

    suspend fun findUserByEmail(email:String):User?

    suspend fun findUser(email: String, firstName: String, lastName: String, age: Int):User?
}