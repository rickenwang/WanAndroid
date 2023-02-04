package com.leaf.feature.login.model

import com.leaf.feature.common.exception.ServiceNotFoundException
import com.leaf.feature.common.services.server.IServerService
import com.leaf.feature.common.services.server.wanandroid.IWanAndroidService
import com.leaf.feature.common.services.server.wanandroid.WanAndroidResponse
import com.leaf.feature.common.services.server.wanandroid.data
import com.leaf.feature.common.services.server.wanandroid.entities.LoginEntity
import com.leaf.feature.common.widget.repository.WanAndroidRepository
import com.therouter.TheRouter


/**
 *
 * Created by leafwang on 2023/2/2.
 */
class RemoteLoginRepository: WanAndroidRepository(), LoginRepository {


    override suspend fun login(name: String, password: String): LoginEntity {

        return ensureWanAndroidServer().login(name, password).data
    }


}