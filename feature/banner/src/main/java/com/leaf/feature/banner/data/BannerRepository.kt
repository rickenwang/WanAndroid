package com.leaf.feature.banner.data

import com.leaf.feature.common.services.server.wanandroid.data
import com.leaf.feature.common.services.server.wanandroid.entities.ListBannerEntity
import com.leaf.feature.common.widget.repository.WanAndroidRepository


/**
 *
 * Created by leafwang on 2023/2/3.
 */
class BannerRepository: WanAndroidRepository() {


    suspend fun listBanner(): ListBannerEntity {
        return ensureWanAndroidServer().listBanner().data
    }
}