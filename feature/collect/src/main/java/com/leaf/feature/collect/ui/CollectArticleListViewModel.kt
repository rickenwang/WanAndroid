package com.leaf.feature.collect.ui

import com.leaf.feature.common.services.article.ArticleListItemViewState
import com.leaf.feature.common.services.article.ArticleListViewState
import com.leaf.feature.collect.model.CollectRepository
import com.leaf.feature.common.widget.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow


/**
 *
 * Created by leafwang on 2023/2/3.
 */
class CollectArticleListViewModel: BaseViewModel() {

    private val mCollectRepository = CollectRepository()

    val mArticleListFlow: MutableStateFlow<ArticleListViewState> =
        MutableStateFlow(ArticleListViewState.Init)

    suspend fun listArticle() {
        mArticleListFlow.value = ArticleListViewState.Loading

        try {
            val listArticleEntity = mCollectRepository.listCollectArticles(0)
            mArticleListFlow.value = if (listArticleEntity.errorCode == 0) {
                val items = listArticleEntity.data.datas.map {
                    ArticleListItemViewState(it.title, it.author)
                }
                ArticleListViewState.Success(items)
            } else {
                ArticleListViewState.Failure(listArticleEntity.errorCode, listArticleEntity.errorMessage, null)
            }
        } catch (e: Exception) {
            mArticleListFlow.value = ArticleListViewState.Failure(-1, "", e)
        }

    }

}