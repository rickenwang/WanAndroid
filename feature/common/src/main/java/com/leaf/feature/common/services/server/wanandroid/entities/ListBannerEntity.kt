package com.leaf.feature.common.services.server.wanandroid.entities


/**
 *
 * Created by leafwang on 2023/2/2.
 */

// https://www.wanandroid.com/banner/json

data class ListBannerEntity (
    val errorCode: Int = 0,
    val errorMessage: String? = null,
    val data: List<BannerEntity>,
)

data class BannerEntity(
    val id: Int,
    val desc: String,
    val imagePath: String,
)
