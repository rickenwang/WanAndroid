package com.leaf.feature.common.services.banner

import android.view.View
import androidx.fragment.app.Fragment


/**
 *
 * Created by leafwang on 2023/2/5.
 */
interface BannerViewDelegate {

    fun bannerView(): View

    fun loadBanner(fragment: Fragment)
}