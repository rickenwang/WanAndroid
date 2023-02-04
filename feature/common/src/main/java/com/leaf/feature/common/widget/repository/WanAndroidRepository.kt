package com.leaf.feature.common.widget.repository

import com.leaf.feature.common.exception.ServiceNotFoundException
import com.leaf.feature.common.services.server.IServerService
import com.leaf.feature.common.services.server.wanandroid.IWanAndroidService
import com.therouter.TheRouter


/**
 *
 * Created by leafwang on 2023/2/3.
 */
abstract class WanAndroidRepository: BaseRepository {

    private var mWanAndroidService: IWanAndroidService? = null

    fun ensureWanAndroidServer(): IWanAndroidService {

        val service = mWanAndroidService
        if (service != null) {
            return service
        }

        val serverService = TheRouter.get(IServerService::class.java)
            ?: throw ServiceNotFoundException("IServerService Not found")
        val wanService = serverService.wanAndroidServer()
        mWanAndroidService = wanService
        return wanService
    }
}