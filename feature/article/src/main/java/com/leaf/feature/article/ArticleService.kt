package com.leaf.feature.article

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.leaf.feature.article.model.ArticleListRepository
import com.leaf.feature.article.ui.inflateArticleList
import com.leaf.feature.common.services.article.IArticleService
import com.leaf.feature.common.services.server.wanandroid.entities.ListArticleEntity
import com.therouter.inject.ServiceProvider

@Suppress("unused")
class ArticleService: IArticleService {

    private val mArticleListRepository = ArticleListRepository()

    override suspend fun listArticles(page: Int): ListArticleEntity {
        return mArticleListRepository.listArticles(page)
    }

    override fun inflateRvWithArticleListDataSource(
        fragment: Fragment,
        recyclerView: RecyclerView,
    ) {

        inflateArticleList(fragment, recyclerView)
    }


}

@ServiceProvider(returnType = IArticleService::class)
fun provideLoginService() = ArticleService()


