package com.leaf.feature.article.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.leaf.feature.article.R
import com.leaf.feature.common.services.article.ArticleListViewState
import com.leaf.feature.common.widget.fragment.BaseFragment
import com.leaf.feature.common.widget.rv.DiffMultiTypeAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.LinkedList


/**
 *
 * Created by leafwang on 2023/2/2.
 */
class ArticleListFragment: BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_article_list, container)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_article_list)
        initRecyclerView(recyclerView)

        return view
    }

    private fun initRecyclerView(recyclerView: RecyclerView) {

        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = DiffMultiTypeAdapter()
        val delegate = ArticleListViewDelegate()
        adapter.register(delegate)
        recyclerView.adapter = adapter

        val viewModel = ViewModelProvider(this).get(ArticleListViewModel::class.java)
        lifecycleScope.launch {
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
        lifecycleScope.launch {
            viewModel.listArticle()
        }

    }

}

