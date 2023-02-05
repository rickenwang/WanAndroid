package com.leaf.feature.article.ui

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.leaf.feature.common.widget.rv.BaseRvDelegate
import com.leaf.feature.common.widget.rv.BaseViewHolder
import com.leaf.feature.common.widget.rv.DiffMultiTypeAdapter
import com.leaf.feature.common.widget.toast.showToast
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


/**
 *
 * Created by leafwang on 2023/2/5.
 */

fun inflateArticleList(fragment: Fragment, recyclerView: RecyclerView) {

    recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
    val adapter = DiffMultiTypeAdapter()
    val delegate = ArticleListViewDelegate()
    adapter.register(delegate)
    recyclerView.adapter = adapter

    // 列表项点击监听
    delegate.onItemClickListener = object
        : BaseRvDelegate.OnItemClickListener<ArticleListItemViewState> {
        override fun onItemClick(holder: BaseViewHolder, item: ArticleListItemViewState) {
            val context = fragment.context
            context?.let{
                showToast(it, item.title)
            }
        }
    }

    //
    val viewModel = ViewModelProvider(fragment).get(ArticleListViewModel::class.java)
    fragment.lifecycleScope.launch {
        viewModel.mArticleListFlow.collect {

            when(it) {

                is ArticleListViewState.Success -> {
                    adapter.setContentData(it.items)
                }

                else -> {

                }

            }
        }
    }
    fragment.lifecycleScope.launch {
        viewModel.listArticle()
    }
}