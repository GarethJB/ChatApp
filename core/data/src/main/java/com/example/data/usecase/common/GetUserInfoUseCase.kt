package com.example.data.usecase.common

import com.example.data.repository.common.CommonRepository
import javax.inject.Inject

class GetUserInfoUseCase @Inject constructor(
    private val repository: CommonRepository
){
    operator fun invoke(map: Map<String, String>) = repository.getUserInfo(map)

}