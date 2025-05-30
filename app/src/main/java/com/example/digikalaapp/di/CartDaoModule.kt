package com.example.digikalaapp.di

import com.example.digikalaapp.data.db.CartDao
import com.example.digikalaapp.data.db.DigikalaDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CartDaoModule {

    @Provides
    @Singleton
    fun provideCardDao(
        database: DigikalaDatabase
    ): CartDao = database.cartDao()
}