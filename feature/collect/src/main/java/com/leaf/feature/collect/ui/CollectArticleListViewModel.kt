package com.leaf.feature.collect.ui

import com.leaf.feature.collect.model.CollectRepository
import com.leaf.feature.common.widget.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow

/**
 *
 * Created by leafwang on 2023/2/3.
 */
class CollectArticleListViewModel: BaseViewModel() {

    private val mCollectRepository = CollectRepository()

    val mCollectArticleListFlow: MutableStateFlow<CollectArticleListViewState> =
        MutableStateFlow(CollectArticleListViewState.Init)

    suspend fun listArticle() {
        mCollectArticleListFlow.value = CollectArticleListViewState.Loading

        try {
            val listCollectArticleEntity = mCollectRepository.listCollectArticles(0)
            mCollectArticleListFlow.value = if (listCollectArticleEntity.errorCode == 0) {
                val items = listCollectArticleEntity.data.datas.map {
                    CollectArticleListItemViewState(it.title, it.author)
                }
                CollectArticleListViewState.Success(items)
            } else {
                CollectArticleListViewState.Failure(listCollectArticleEntity.errorCode, listCollectArticleEntity.errorMessage, null)
            }
        } catch (e: Exception) {
            mCollectArticleListFlow.value = CollectArticleListViewState.Failure(-1, "", e)
        }

    }

}