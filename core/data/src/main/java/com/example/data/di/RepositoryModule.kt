package com.example.data.di

import com.example.data.repository.common.CommonRepository
import com.example.data.repository.common.CommonRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindsCommonRepository(commonRepository: CommonRepositoryImpl): CommonRepository

}