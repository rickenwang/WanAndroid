package com.leaf.feature.common.utils


/**
 *
 * Created by leafwang on 2023/2/4.
 */


fun List<String>.flatToString(): String {

    val sb = StringBuilder()
    for (s in this) {
        sb.append(s).append("$$")
    }
    return sb.toString()
}