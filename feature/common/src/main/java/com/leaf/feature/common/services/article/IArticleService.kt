package com.leaf.feature.common.services.article

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.leaf.feature.common.services.server.wanandroid.entities.ListArticleEntity
import com.leaf.feature.common.widget.rv.DiffMultiTypeAdapter


/**
 * 对于 feature 中的模块，一般可以分为
 * - model
 * - domain
 * - ui
 * 三层，模块可以有自己的 UI，同时其他模块，比如 business 中的模块可以自己设计 ui 层，
 * 仅仅使用其 model 层的数据
 *
 * Created by leafwang on 2023/2/4.
 */
interface IArticleService {

    // 暴露数据层
    suspend fun listArticles(page: Int): ListArticleEntity

    /**
     *
     */
    fun inflateRvWithArticleListDataSource(fragment: Fragment,
                                           recyclerView: RecyclerView,
    )
}