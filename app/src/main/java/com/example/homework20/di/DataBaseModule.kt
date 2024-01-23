package com.example.homework20.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.homework20.data.local.dao.UserDao
import com.example.homework20.data.local.database.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Singleton
    @Provides
    fun provideAppDataBase(@ApplicationContext context: Context): AppDataBase{
        return Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            "usersDataBase"
        ).build()
    }

    @Singleton
    @Provides
    fun provideUserDao(appDataBase:AppDataBase):UserDao{
        return appDataBase.userDao()
    }
}