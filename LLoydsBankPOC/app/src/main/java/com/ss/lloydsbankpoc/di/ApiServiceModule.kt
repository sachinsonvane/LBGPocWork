package com.ss.lloydsbankpoc.di

import com.ss.lloydsbankpoc.data.remote.services.MainApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiServiceModule {
    @Provides
    @Singleton
    fun provideSearchAppService(retrofit: Retrofit): MainApiService {
        return retrofit.create(MainApiService::class.java)
    }
}