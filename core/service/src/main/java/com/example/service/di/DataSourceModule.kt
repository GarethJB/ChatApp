package com.example.service.di

import com.example.service.datasource.common.CommonDataSource
import com.example.service.datasource.common.CommonDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindsCommonDataSource(commonDataSource: CommonDataSourceImpl): CommonDataSource

}