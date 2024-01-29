package com.example.homework20.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.homework20.data.local.model.UserEntity

@Dao
interface UserDao {

    @Update
    suspend fun updateUser(user: UserEntity)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertAll(vararg users: UserEntity)

    @Query("DELETE FROM userentity WHERE mail = :email AND firstName = :firstName AND lastName = :lastName AND age = :age")
    suspend fun deleteUser(email: String, firstName: String, lastName: String, age: Int)

    @Query("SELECT * FROM userentity WHERE mail = :email LIMIT 1")
    suspend fun findUserByEmail(email: String): UserEntity?

    @Query("SELECT * FROM userentity WHERE mail = :email AND firstName = :firstName AND lastName = :lastName AND age = :age LIMIT 1")
    suspend fun findUserByAllInfo(email: String, firstName: String, lastName: String, age: Int):UserEntity?
}