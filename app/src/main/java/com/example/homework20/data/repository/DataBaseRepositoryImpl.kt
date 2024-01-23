package com.example.homework20.data.repository

import com.example.homework20.data.local.dao.UserDao
import com.example.homework20.data.local.mapper.toDomain
import com.example.homework20.data.local.mapper.toEntity
import com.example.homework20.domain.model.User
import com.example.homework20.domain.repository.DataBaseRepository
import javax.inject.Inject

class DataBaseRepositoryImpl @Inject constructor(private val userDao: UserDao): DataBaseRepository{

    override suspend fun getAllUsers(): List<User> {
        return userDao.getAll().map {
            it.toDomain()
        }
    }

    override suspend fun insertUser(user: User) {
        userDao.insertAll(user.toEntity())
    }

    override suspend fun deleteUser(user: User) {
        userDao.delete(user.toEntity())
    }
}