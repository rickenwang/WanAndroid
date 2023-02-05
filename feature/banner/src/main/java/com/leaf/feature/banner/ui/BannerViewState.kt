package com.leaf.feature.banner.ui

import com.leaf.feature.common.services.server.wanandroid.entities.BannerEntity


/**
 *
 * Created by leafwang on 2023/2/3.
 */

sealed interface BannerViewState{

    object Init: BannerViewState

    object Loading: BannerViewState

    data class Failure(val errorCode: Int, val errorMsg: String?, val exception: Exception?):
        BannerViewState

    data class Success(val banner: List<BannerEntity>): BannerViewState {}

}