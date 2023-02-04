package com.leaf.feature.common.widget.rv

interface IDiffItem {

    /**
     * 列表项的唯一标识
     */
    fun id(): String

    /**
     * 内容是否相同
     */
    fun contentsEqual(other: Any?): Boolean

    // fun deepCopy(): IDiffItem

    /**
     * 可用于局部刷新
     */
    fun payload(o: IDiffItem): List<String>?



}