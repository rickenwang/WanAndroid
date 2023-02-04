package com.leaf.feature.banner

import com.leaf.feature.common.services.server.wanandroid.IWanAndroidService
import com.therouter.inject.ServiceProvider

/**
 * 网络服务管理工具，所有的网络服务都需要交给该类管理，便于统一处理
 */
@Suppress("unused")
class BannerService {

}

@ServiceProvider
fun provideLoginService() = BannerService()


