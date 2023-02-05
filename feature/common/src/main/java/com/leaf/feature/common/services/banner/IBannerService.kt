package com.leaf.feature.common.services.banner

import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment
import com.leaf.feature.common.services.server.wanandroid.entities.ListArticleEntity
import com.leaf.feature.common.services.server.wanandroid.entities.ListBannerEntity
import com.leaf.feature.common.widget.rv.BaseRvDelegate
import com.leaf.feature.common.widget.rv.BaseViewHolder


/**
 *
 * Created by leafwang on 2023/2/4.
 */
interface IBannerService {

    fun getBanner(context: Context): BannerViewDelegate
}