package com.leaf.business.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.leaf.business.home.ui.ArticleListViewDelegate
import com.leaf.business.home.ui.HomeViewModel
import com.leaf.feature.common.services.article.ArticleListViewState
import com.leaf.feature.common.services.article.IArticleService
import com.leaf.feature.common.services.banner.IBannerService
import com.leaf.feature.common.widget.fragment.BaseFragment
import com.leaf.feature.common.widget.rv.DiffMultiTypeAdapter
import com.therouter.TheRouter
import com.therouter.router.Route
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


/**
 * 首页
 *
 * 一般包含两个部分：
 * banner 和文章列表，均作为 RecyclerView 的列表项来展示
 *
 * Created by leafwang on 2023/2/4.
 */
@Route(path = "http://wanandroid.com/home")
class HomeFragment: BaseFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container)
        initView(view)
        return view
    }

    private fun initView(view: View) {
        //
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_home)
        initRecyclerView(recyclerView)
    }

    private fun initRecyclerView(recyclerView: RecyclerView) {

        val viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = DiffMultiTypeAdapter()

        adapter.register(ArticleListViewDelegate())

        recyclerView.adapter = adapter

        lifecycleScope.launch {
            viewModel.mArticleListFlow.collect {

                when(it) {

                    is ArticleListViewState.Success -> {

                        adapter.setContentData(it.items)
                    }

                    else -> {}
                }
            }
        }

        lifecycleScope.launch {
            viewModel.listArticle()
        }
    }

}