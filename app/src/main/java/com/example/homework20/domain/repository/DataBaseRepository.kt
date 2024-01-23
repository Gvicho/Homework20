package com.example.homework20.domain.repository

import com.example.homework20.domain.model.User

interface DataBaseRepository {
    suspend fun getAllUsers(): List<User>
    suspend fun insertUser(user: User)
    suspend fun deleteUser(user: User)
}