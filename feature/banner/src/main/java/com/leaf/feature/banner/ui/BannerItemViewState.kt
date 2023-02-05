package com.leaf.feature.banner.ui

import com.leaf.feature.common.utils.flatToString
import com.leaf.feature.common.widget.rv.IDiffItem


/**
 *
 * Created by leafwang on 2023/2/3.
 */
data class BannerItemViewState(
    val imageUrls: List<String> = emptyList(),
): IDiffItem {

    override fun id(): String {
        return imageUrls.flatToString()
    }

    override fun contentsEqual(other: Any?): Boolean {
        return other is BannerItemViewState && other.imageUrls.flatToString() == imageUrls.flatToString()
    }

    override fun payload(o: IDiffItem): List<String>? {
        return null
    }
}