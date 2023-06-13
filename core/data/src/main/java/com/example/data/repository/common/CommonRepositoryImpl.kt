package com.example.data.repository.common

import com.example.service.datasource.common.CommonDataSource
import javax.inject.Inject

class CommonRepositoryImpl @Inject constructor(
    private val dataSource: CommonDataSource
) : CommonRepository {

    override fun getUserInfo(map: Map<String, String>) = dataSource.getUserInfo(map)

}
