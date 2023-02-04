package com.leaf.feature.common.widget.viewpager

import androidx.viewpager2.widget.ViewPager2


/**
 *
 * Created by leafwang on 2023/2/3.
 */
interface PageIndicator {

    fun setViewPager(viewPager: ViewPager2, initialPosition: Int = 0)

    fun setCurrentItem(item: Int)

    fun setOnPageChangeListener(listener: ViewPager2.OnPageChangeCallback)

    fun notifyDataSetChanged()
}