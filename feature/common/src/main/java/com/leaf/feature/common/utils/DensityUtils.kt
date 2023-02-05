package com.leaf.feature.common.utils

import android.content.Context
import kotlin.math.roundToInt


/**
 *
 * Created by leafwang on 2023/2/5.
 */

fun dip2px(context: Context, dpValue: Float): Int {
    val scale = context.resources.displayMetrics.density
    return (dpValue * scale + 0.5f).roundToInt()
}

/**
 * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
 */
fun px2dip(context: Context, pxValue: Float): Int {
    val scale = context.resources.displayMetrics.density
    return (pxValue / scale + 0.5f).roundToInt()
}