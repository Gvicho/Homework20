package com.example.homework20.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.homework20.data.local.dao.UserDao
import com.example.homework20.data.local.model.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AppDataBase :RoomDatabase(){

    abstract fun userDao():UserDao
}