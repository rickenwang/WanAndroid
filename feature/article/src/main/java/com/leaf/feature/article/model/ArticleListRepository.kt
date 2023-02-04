package com.leaf.feature.article.model

import com.leaf.feature.common.services.server.wanandroid.data
import com.leaf.feature.common.services.server.wanandroid.entities.ListArticleEntity
import com.leaf.feature.common.widget.repository.WanAndroidRepository


/**
 *
 * Created by leafwang on 2023/2/3.
 */
class ArticleListRepository: WanAndroidRepository() {


    suspend fun listArticles(page: Int): ListArticleEntity {
        return ensureWanAndroidServer().listArticles(page).data
    }
}