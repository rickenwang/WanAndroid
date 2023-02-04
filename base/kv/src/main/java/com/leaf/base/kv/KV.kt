package com.leaf.base.kv


/**
 *
 * Created by leafwang on 2023/2/2.
 */
interface KV {

    fun put(key: String, value: Boolean)

    fun getBoolean(key: String, default: Boolean): Boolean

    fun put(key: String, value: String)

    fun getString(key: String): String?
}