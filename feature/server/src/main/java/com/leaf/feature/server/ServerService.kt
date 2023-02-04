package com.leaf.feature.server

import com.leaf.feature.common.services.server.IServerService
import com.leaf.feature.common.services.server.wanandroid.IWanAndroidService
import com.therouter.inject.ServiceProvider

/**
 * 网络服务管理工具，所有的网络服务都需要交给该类管理，便于统一处理
 */
@Suppress("unused")
class ServerService: IServerService {

    // wanandroid 后台服务
    override fun wanAndroidServer() = IWanAndroidService.service
}

@ServiceProvider(returnType = IServerService::class)
fun provideServerService() = ServerService()


