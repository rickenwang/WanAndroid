package com.leaf.feature.banner

import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment
import com.leaf.feature.banner.ui.BannerView
import com.leaf.feature.banner.ui.BannerViewHolder
import com.leaf.feature.banner.ui.WanAndroidBannerAdapter
import com.leaf.feature.common.services.banner.BannerViewDelegate
import com.leaf.feature.common.services.banner.IBannerService
import com.therouter.inject.ServiceProvider
import com.youth.banner.Banner
import com.youth.banner.indicator.CircleIndicator

@Suppress("unused")
class BannerService: IBannerService {

    override fun getBanner(context: Context): BannerViewDelegate {
        return BannerView(context)
    }


}

@ServiceProvider(returnType = IBannerService::class)
fun provideLoginService() = BannerService()


