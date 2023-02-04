package com.leaf.feature.login.ui

import com.leaf.feature.common.services.server.wanandroid.entities.LoginEntity


/**
 *
 * Created by leafwang on 2023/2/2.
 */
sealed interface LoginUIState {

    // 还未还开始登录
    object Initial: LoginUIState

    // 登录中
    object Loading: LoginUIState

    // 登录失败
    object Failed: LoginUIState

    data class Success(val loginEntity: LoginEntity): LoginUIState
}