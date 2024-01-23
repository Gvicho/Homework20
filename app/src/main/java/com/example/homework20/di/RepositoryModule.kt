package com.example.homework20.di

import com.example.homework20.data.local.dao.UserDao
import com.example.homework20.data.repository.DataBaseRepositoryImpl
import com.example.homework20.domain.repository.DataBaseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataBaseRepository(userDao: UserDao): DataBaseRepository {
        return DataBaseRepositoryImpl(userDao)
    }
}