package com.leaf.feature.common.services.server

import com.leaf.feature.common.services.server.wanandroid.IWanAndroidService


/**
 *
 * Created by leafwang on 2023/2/2.
 */
interface IServerService {

    fun wanAndroidServer(): IWanAndroidService
}