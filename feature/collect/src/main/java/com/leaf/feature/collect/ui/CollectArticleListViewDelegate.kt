package com.leaf.feature.collect.ui

import android.view.View
import android.widget.TextView
import com.leaf.feature.collect.R
import com.leaf.feature.common.widget.rv.BaseRvDelegate
import com.leaf.feature.common.widget.rv.BaseViewHolder


/**
 *
 * Created by leafwang on 2023/2/3.
 */
class CollectArticleListViewDelegate: BaseRvDelegate<CollectArticleListItemViewState,
        CollectArticleListItemViewHolder>(R.layout.collect_article_list_item) {

    override fun onBindViewHolder(
        holder: CollectArticleListItemViewHolder,
        item: CollectArticleListItemViewState
    ) {
        holder.refresh(item)
    }

    override fun onCreateViewHolder(item: View): CollectArticleListItemViewHolder {
        return CollectArticleListItemViewHolder(item)
    }

}

class CollectArticleListItemViewHolder(item: View): BaseViewHolder(item) {

    private val mTVTitle: TextView

    init {
        mTVTitle = item.findViewById(R.id.tv_title)
    }

    fun refresh(state: CollectArticleListItemViewState) {
        mTVTitle.text = state.title
    }

}