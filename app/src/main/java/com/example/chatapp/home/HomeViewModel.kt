package com.example.chatapp.home

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.base.BaseViewModel
import com.example.data.usecase.common.GetUserInfoUseCase
import com.example.model.common.UserInfoResponseData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    app: Application,
    private val getUserInfoUseCase: GetUserInfoUseCase
) : BaseViewModel(app) {


    private val _userInfoData = MutableLiveData<UserInfoResponseData>()
    val userInfoData: LiveData<UserInfoResponseData> = _userInfoData



    fun getUserInfo(memNo: String) = flow<UserInfoResponseData> {
        val map = mapOf(
            "reference" to "member",
            "child" to "id",
            "equalTo" to memNo
        )
        getUserInfoUseCase.invoke(map).collect {
            _userInfoData.value = it
        }
    }


}