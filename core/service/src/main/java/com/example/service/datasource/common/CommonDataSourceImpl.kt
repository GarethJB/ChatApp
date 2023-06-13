package com.example.service.datasource.common

import com.example.model.common.UserInfoResponseData
import com.example.service.network.firebase.FirebaseNetwork
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class CommonDataSourceImpl @Inject constructor(
    private val firebaseNetwork: FirebaseNetwork
) : CommonDataSource {

    override fun getUserInfo(map: Map<String, String>): Flow<UserInfoResponseData> = flow {
        firebaseNetwork.getDataSingleValueEventListener(map).collect { snapshot ->
            try {
                snapshot.children.map { dataSnapshot ->
                    dataSnapshot.getValue(UserInfoResponseData::class.java)!!
                }.let {
                    emit(it[0])
                }
            } catch (e: Exception) {

            }
        }
    }


}