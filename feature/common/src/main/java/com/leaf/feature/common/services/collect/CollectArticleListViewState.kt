package com.leaf.feature.common.services.collect


/**
 *
 * Created by leafwang on 2023/2/3.
 */
sealed interface CollectArticleListViewState{

    object Init: CollectArticleListViewState

    object Loading: CollectArticleListViewState

    data class Failure(val exception: Exception): CollectArticleListViewState

    data class Success(val items: List<CollectArticleListItemViewState>): CollectArticleListViewState {}

}