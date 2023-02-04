package com.leaf.feature.login

import com.leaf.feature.common.services.server.wanandroid.IWanAndroidService
import com.therouter.inject.ServiceProvider

/**
 * 网络服务管理工具，所有的网络服务都需要交给该类管理，便于统一处理
 */
@Suppress("unused")
class LoginService {

}

@ServiceProvider
fun provideLoginService() = LoginService()


