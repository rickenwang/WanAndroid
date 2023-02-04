package com.leaf.feature.login.ui

import com.leaf.feature.common.services.server.wanandroid.entities.LoginEntity
import com.leaf.feature.common.widget.state.UIState
import com.leaf.feature.common.widget.viewmodel.BaseViewModel
import com.leaf.feature.login.model.RemoteLoginRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


/**
 *
 * Created by leafwang on 2023/2/2.
 */
class LoginViewModel: BaseViewModel() {

    private val mLoginRepository = RemoteLoginRepository()

    val mLoginUIStateFlow: MutableStateFlow<LoginUIState> = MutableStateFlow(LoginUIState.Initial)

    suspend fun login(name: String, password: String) {

        try {
            mLoginUIStateFlow.value = LoginUIState.Loading
            val loginEntity = mLoginRepository.login(name, password)
            mLoginUIStateFlow.value = LoginUIState.Success(loginEntity)
        } catch (e: Exception) {
            mLoginUIStateFlow.value = LoginUIState.Failed
        }

    }
}