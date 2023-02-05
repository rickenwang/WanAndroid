package com.leaf.feature.article.ui

import com.leaf.feature.article.model.ArticleListRepository
import com.leaf.feature.common.widget.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow


/**
 *
 * Created by leafwang on 2023/2/3.
 */
class ArticleListViewModel: BaseViewModel() {

    private val mArticleListRepository = ArticleListRepository()

    val mArticleListFlow: MutableStateFlow<ArticleListViewState> =
        MutableStateFlow(ArticleListViewState.Init)

    suspend fun listArticle() {
        mArticleListFlow.value = ArticleListViewState.Loading

        try {
            val listArticleEntity = mArticleListRepository.listArticles(0)
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