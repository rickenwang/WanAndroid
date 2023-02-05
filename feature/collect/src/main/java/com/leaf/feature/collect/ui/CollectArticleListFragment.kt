package com.leaf.feature.collect.ui

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.leaf.feature.collect.R
import com.leaf.feature.common.widget.fragment.BaseFragment
import com.leaf.feature.common.widget.rv.DiffMultiTypeAdapter
import com.therouter.TheRouter
import com.therouter.router.Navigator
import com.therouter.router.Route
import com.therouter.router.interceptor.NavigationCallback
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


/**
 *
 * Created by leafwang on 2023/2/2.
 */
@Route(path = "http://wanandroid.com/collect_article")
class CollectArticleListFragment: BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_collect_article_list, container)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_article_list)
        initRecyclerView(recyclerView)

        return view
    }

    private fun initRecyclerView(recyclerView: RecyclerView) {

        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = DiffMultiTypeAdapter()
        val delegate = CollectArticleListViewDelegate()
        adapter.register(delegate)
        recyclerView.adapter = adapter

        val viewModel = ViewModelProvider(this).get(CollectArticleListViewModel::class.java)

        lifecycleScope.launch {
            viewModel.mCollectArticleListFlow.collect {

                when(it) {

                    is CollectArticleListViewState.Success -> {
                        adapter.setContentData(it.items)
                    }
                    is CollectArticleListViewState.Failure -> {
                        // 请先登录
                        if (it.errorCode == -1001) {
                            routeToLogin()
                        }
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

    private fun routeToLogin() {
        TheRouter.build("http://wanandroid.com/login").navigation(this,
            object : NavigationCallback() {
                override fun onActivityCreated(navigator: Navigator, destActivity: Activity) {
                    super.onActivityCreated(navigator, destActivity)
                    activity?.finish()
                }
            })
    }
}

