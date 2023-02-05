package com.leaf.business.home.ui

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.leaf.feature.common.services.banner.IBannerService
import com.leaf.feature.common.utils.dip2px
import com.leaf.feature.common.widget.rv.BaseRvDelegate
import com.leaf.feature.common.widget.rv.BaseViewHolder
import com.leaf.feature.common.widget.rv.IDiffItem
import com.therouter.TheRouter

/**
 *
 * Created by leafwang on 2023/2/3.
 */
class BannerViewDelegate(val fragment: Fragment): BaseRvDelegate<BannerItem,
        BannersViewHolder>(0) {

    override fun onCreateItemView(context: Context, parent: ViewGroup): View {
        val bannerService = TheRouter.get(IBannerService::class.java)!!
        val bannerViewDelegate = bannerService.getBanner(context)
        bannerViewDelegate.loadBanner(fragment)
        val view = bannerViewDelegate.bannerView()
        view.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            dip2px(context, 200f)
        )
        return view
    }


    override fun onBindViewHolder(
        holder: BannersViewHolder,
        item: BannerItem
    ) {

    }

    override fun onCreateViewHolder(item: View): BannersViewHolder {
        return BannersViewHolder(item)
    }

}

class BannerItem(): IDiffItem {
    override fun id(): String {
        return ""
    }

    override fun contentsEqual(other: Any?): Boolean {
       return false
    }

    override fun payload(o: IDiffItem): List<String>? {
        return null
    }
}

class BannersViewHolder(item: View): BaseViewHolder(item) {

}


