package com.leaf.feature.collect.ui


/**
 *
 * Created by leafwang on 2023/2/3.
 */
sealed interface CollectArticleListViewState{

    object Init: CollectArticleListViewState

    object Loading: CollectArticleListViewState

    data class Failure(val errorCode: Int = 0, val errorMessage:String? = null, val exception: Exception?): CollectArticleListViewState

    data class Success(val items: List<CollectArticleListItemViewState>):
        CollectArticleListViewState {}

}