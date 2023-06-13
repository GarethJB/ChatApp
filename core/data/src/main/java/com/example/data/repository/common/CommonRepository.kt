package com.example.data.repository.common

import com.example.model.common.UserInfoResponseData
import kotlinx.coroutines.flow.Flow

interface CommonRepository {

    fun getUserInfo(map: Map<String, String>): Flow<UserInfoResponseData>

}