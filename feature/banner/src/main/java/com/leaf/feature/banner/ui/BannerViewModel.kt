package com.leaf.feature.banner.ui

import com.leaf.feature.banner.data.BannerRepository
import com.leaf.feature.common.widget.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow


/**
 *
 * Created by leafwang on 2023/2/3.
 */
class BannerViewModel: BaseViewModel() {

    private val mBannerRepository = BannerRepository()

    val mBannerFlow: MutableStateFlow<BannerViewState> =
        MutableStateFlow(BannerViewState.Init)

    suspend fun listBanner() {
        mBannerFlow.value = BannerViewState.Loading

        try {
            val listBannerEntity = mBannerRepository.listBanner()

            mBannerFlow.value = if (listBannerEntity.errorCode == 0) {
                val items = listBannerEntity.data
                BannerViewState.Success(items)
            } else {
                BannerViewState.Failure(listBannerEntity.errorCode, listBannerEntity.errorMessage, null)
            }
        } catch (e: Exception) {
            mBannerFlow.value = BannerViewState.Failure(-1, "", e)
        }
    }

}