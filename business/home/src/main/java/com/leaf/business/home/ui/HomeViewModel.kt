package com.leaf.business.home.ui

import com.leaf.feature.common.services.article.ArticleListItemViewState
import com.leaf.feature.common.services.article.ArticleListViewState
import com.leaf.feature.common.services.article.IArticleService
import com.leaf.feature.common.widget.viewmodel.BaseViewModel
import com.therouter.TheRouter
import kotlinx.coroutines.flow.MutableStateFlow


/**
 *
 * Created by leafwang on 2023/2/3.
 */
class HomeViewModel: BaseViewModel() {

    val mArticleListFlow: MutableStateFlow<ArticleListViewState> =
        MutableStateFlow(ArticleListViewState.Init)

    suspend fun listArticle() {
        mArticleListFlow.value = ArticleListViewState.Loading

        try {
            val listArticleEntity = TheRouter.get(IArticleService::class.java)!!.listArticles(0)
            val items = listArticleEntity.data.datas.map {
                ArticleListItemViewState(it.title, it.author)
            }
            mArticleListFlow.value = if (listArticleEntity.errorCode == 0) {
                ArticleListViewState.Success(items)
            } else {
                ArticleListViewState.Failure(listArticleEntity.errorCode, listArticleEntity.errorMessage, null)
            }
        } catch (e: Exception) {
            mArticleListFlow.value = ArticleListViewState.Failure(-1, "", e)
        }

    }

}