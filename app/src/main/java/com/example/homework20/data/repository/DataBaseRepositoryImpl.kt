package com.example.homework20.data.repository

import com.example.homework20.data.local.dao.UserDao
import com.example.homework20.data.local.mapper.toDomain
import com.example.homework20.data.local.mapper.toEntity
import com.example.homework20.domain.model.User
import com.example.homework20.domain.repository.DataBaseRepository
import javax.inject.Inject

class DataBaseRepositoryImpl @Inject constructor(private val userDao: UserDao): DataBaseRepository{
    override suspend fun updateUser(user: User) {
        userDao.updateUser(user.toEntity())
    }


    override suspend fun insertUser(user: User) {
        userDao.insertAll(user.toEntity())
    }

    override suspend fun deleteUser(email: String, firstName: String, lastName: String, age: Int) {
        userDao.deleteUser(
            email = email,
            firstName = firstName,
            lastName = lastName,
            age = age
        )
    }


    override suspend fun findUserByEmail(email: String): User? {
        return userDao.findUserByEmail(email)?.toDomain()
    }

    override suspend fun findUser(
        email: String,
        firstName: String,
        lastName: String,
        age: Int
    ): User? {
        return userDao.findUserByAllInfo(
            email = email,
            firstName = firstName,
            lastName = lastName,
            age = age
        )?.toDomain()
    }


}