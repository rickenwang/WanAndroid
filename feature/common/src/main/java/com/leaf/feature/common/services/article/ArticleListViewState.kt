package com.leaf.feature.common.services.article


/**
 *
 * Created by leafwang on 2023/2/3.
 */
sealed interface ArticleListViewState{

    object Init: ArticleListViewState

    object Loading: ArticleListViewState

    data class Failure(val errorCode: Int, val errorMsg: String?, val exception: Exception?): ArticleListViewState

    data class Success(val items: List<ArticleListItemViewState>): ArticleListViewState {}

}