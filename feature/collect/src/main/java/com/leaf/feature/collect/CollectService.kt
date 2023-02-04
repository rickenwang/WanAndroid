package com.leaf.feature.collect

import com.leaf.feature.common.services.collect.ICollectService
import com.therouter.inject.ServiceProvider

/**
 * 网络服务管理工具，所有的网络服务都需要交给该类管理，便于统一处理
 */
@Suppress("unused")
class CollectService: ICollectService {

}

@ServiceProvider(returnType = ICollectService::class)
fun provideLoginService() = CollectService()


