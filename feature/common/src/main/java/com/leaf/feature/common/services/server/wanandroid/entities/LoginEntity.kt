package com.leaf.feature.common.services.server.wanandroid.entities;

// {
//    "data": {
//        "admin": false,
//        "chapterTops": [],
//        "coinCount": 33,
//        "collectIds": [],
//        "email": "",
//        "icon": "",
//        "id": 143296,
//        "nickname": "davoswang",
//        "password": "",
//        "publicName": "davoswang",
//        "token": "",
//        "type": 0,
//        "username": "davoswang"
//    },
//    "errorCode": 0,
//    "errorMsg": ""
// }
data class LoginEntity(
        val errorCode: Int = 0,
        val errorMessage: String? = null,
        val data: LoginEntityData? = null,
)

data class LoginEntityData(
        val admin: Boolean,
        val coinCount: Int,
        val id: Int,
        val nickname: String
)
