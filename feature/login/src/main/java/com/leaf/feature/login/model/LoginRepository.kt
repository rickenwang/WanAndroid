package com.leaf.feature.login.model

import com.leaf.feature.common.services.server.wanandroid.entities.LoginEntity


/**
 *
 *
 * Created by leafwang on 2023/2/2.
 */
interface LoginRepository {

    suspend fun login(name: String, password: String): LoginEntity
}