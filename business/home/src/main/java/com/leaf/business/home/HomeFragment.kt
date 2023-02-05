package com.leaf.business.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leaf.business.home.ui.BannerItem
import com.leaf.business.home.ui.BannerViewDelegate
import com.leaf.feature.common.services.article.IArticleService
import com.leaf.feature.common.widget.fragment.BaseFragment
import com.leaf.feature.common.widget.rv.DiffMultiTypeAdapter
import com.therouter.TheRouter
import com.therouter.router.Route


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
        initRecyclerView(view.findViewById<RecyclerView>(R.id.rv_home))
    }

    private fun initRecyclerView(recyclerView: RecyclerView) {

        // 注入 article 列表数据
        val articleService = TheRouter.get(IArticleService::class.java)!!
        articleService.inflateRvWithArticleListDataSource(this, recyclerView)
        val adapter = recyclerView.adapter as DiffMultiTypeAdapter

        // 注入 Banner 数据，作为列表头部
        adapter.register(BannerViewDelegate(this))
        adapter.addHeader(BannerItem())
    }

}