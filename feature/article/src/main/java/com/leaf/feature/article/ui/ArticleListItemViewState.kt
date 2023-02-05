package com.leaf.feature.article.ui

import com.leaf.feature.common.widget.rv.IDiffItem


/**
 *
 * Created by leafwang on 2023/2/3.
 */
data class ArticleListItemViewState(
    val title: String,
    val author: String,
): IDiffItem {
    override fun id(): String {
        return title
    }

    override fun contentsEqual(other: Any?): Boolean {
        return other is ArticleListItemViewState && other.title == title && author == other.author
    }

    override fun payload(o: IDiffItem): List<String>? {
        return null
    }
}