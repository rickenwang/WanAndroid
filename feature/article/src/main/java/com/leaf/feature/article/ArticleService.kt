package com.leaf.feature.article

import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.leaf.feature.article.model.ArticleListRepository
import com.leaf.feature.article.ui.ArticleListViewModel
import com.leaf.feature.common.services.article.ArticleListViewState
import com.leaf.feature.common.services.article.IArticleService
import com.leaf.feature.common.services.server.wanandroid.entities.ListArticleEntity
import com.leaf.feature.common.widget.rv.DiffMultiTypeAdapter
import com.therouter.inject.ServiceProvider
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * 网络服务管理工具，所有的网络服务都需要交给该类管理，便于统一处理
 */
@Suppress("unused")
class ArticleService: IArticleService {

    private val mArticleListRepository = ArticleListRepository()

    override suspend fun listArticles(page: Int): ListArticleEntity {
        return mArticleListRepository.listArticles(page)
    }
}

@ServiceProvider(returnType = IArticleService::class)
fun provideLoginService() = ArticleService()


