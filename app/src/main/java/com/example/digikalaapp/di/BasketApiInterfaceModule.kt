package com.example.digikalaapp.di

import com.example.digikalaapp.data.remote.BasketApiInterface
import com.example.digikalaapp.data.remote.CategoryApiInterface
import com.example.digikalaapp.data.remote.HomeApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BasketApiInterfaceModule {

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): BasketApiInterface =
        retrofit.create(BasketApiInterface::class.java)
}