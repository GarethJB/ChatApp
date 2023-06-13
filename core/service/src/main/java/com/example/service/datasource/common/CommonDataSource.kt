package com.example.service.datasource.common

import com.example.model.common.UserInfoResponseData
import kotlinx.coroutines.flow.Flow

interface CommonDataSource {

    fun getUserInfo(): Flow<UserInfoResponseData>

}