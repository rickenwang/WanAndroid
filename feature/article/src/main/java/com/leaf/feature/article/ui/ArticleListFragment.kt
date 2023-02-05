package com.leaf.feature.article.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leaf.feature.article.R
import com.leaf.feature.common.widget.fragment.BaseFragment


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
        inflateArticleList(this, recyclerView)
        return view
    }

}

