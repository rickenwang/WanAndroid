package com.leaf.feature.collect.model

import com.leaf.feature.common.services.server.wanandroid.data
import com.leaf.feature.common.services.server.wanandroid.entities.ListArticleEntity
import com.leaf.feature.common.widget.repository.WanAndroidRepository


/**
 *
 * Created by leafwang on 2023/2/3.
 */
class CollectRepository: WanAndroidRepository() {


    suspend fun listCollectArticles(page: Int): ListArticleEntity {
        return ensureWanAndroidServer().listCollectedArticles(page).data
    }
}