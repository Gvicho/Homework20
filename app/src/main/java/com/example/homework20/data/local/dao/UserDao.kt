package com.example.homework20.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.homework20.data.local.model.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM userentity ")
    fun getAll(): List<UserEntity>

    @Query("SELECT * FROM userentity WHERE mail IS :email ")
    fun getUserByEmail(email:String):List<UserEntity>

    @Insert
    fun insertAll(vararg users: UserEntity)

    @Delete
    fun delete(user: UserEntity)
}