package com.leaf.feature.collect.ui

import android.view.View
import android.widget.TextView
import com.leaf.feature.collect.R
import com.leaf.feature.common.services.article.ArticleListItemViewState
import com.leaf.feature.common.widget.rv.BaseRvDelegate
import com.leaf.feature.common.widget.rv.BaseViewHolder


/**
 *
 * Created by leafwang on 2023/2/3.
 */
class ArticleListViewDelegate: BaseRvDelegate<ArticleListItemViewState,
        ArticleListItemViewHolder>(R.layout.collect_article_list_item) {

    override fun onBindViewHolder(
        holder: ArticleListItemViewHolder,
        item: ArticleListItemViewState
    ) {
        holder.refresh(item)
    }

    override fun onCreateViewHolder(item: View): ArticleListItemViewHolder {
        return ArticleListItemViewHolder(item)
    }

}

class ArticleListItemViewHolder(item: View): BaseViewHolder(item) {

    private val mTVTitle: TextView

    init {
        mTVTitle = item.findViewById(R.id.tv_title)
    }

    fun refresh(state: ArticleListItemViewState) {
        mTVTitle.text = state.title
    }

}