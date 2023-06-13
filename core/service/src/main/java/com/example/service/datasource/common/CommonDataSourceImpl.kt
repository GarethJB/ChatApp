package com.example.service.datasource.common

import com.example.model.common.UserInfoResponseData
import com.example.service.network.firebase.FirebaseNetwork
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CommonDataSourceImpl @Inject constructor(
    private val firebaseNetwork: FirebaseNetwork
) : CommonDataSource {

    override fun getUserInfo(): Flow<UserInfoResponseData> {

    }


}