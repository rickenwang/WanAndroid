package com.leaf.feature.common.services.collect

import com.leaf.feature.common.widget.rv.IDiffItem


/**
 *
 * Created by leafwang on 2023/2/3.
 */
data class CollectArticleListItemViewState(
    val title: String,
    val author: String,
): IDiffItem {
    override fun id(): String {
        return title
    }

    override fun contentsEqual(other: Any?): Boolean {
        return other is CollectArticleListItemViewState && other.title == title && author == other.author
    }

    override fun payload(o: IDiffItem): List<String>? {
        return null
    }
}