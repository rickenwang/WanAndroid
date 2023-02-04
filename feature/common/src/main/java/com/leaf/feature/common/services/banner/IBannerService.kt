package com.leaf.feature.common.services.banner

import com.leaf.feature.common.widget.rv.BaseRvDelegate
import com.leaf.feature.common.widget.rv.BaseViewHolder


/**
 *
 * Created by leafwang on 2023/2/4.
 */
interface IBannerService {

    fun bannerRvDelegate(): BaseRvDelegate<BannerViewState, BaseViewHolder>
}