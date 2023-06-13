package com.example.model.common

data class UserInfoResponseData(
    var memNo: Int = 0,
    val memNick: String,
    val profileImg: String,
    val onLobby: Boolean
)
