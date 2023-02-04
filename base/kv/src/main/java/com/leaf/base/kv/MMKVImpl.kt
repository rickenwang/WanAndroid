package com.leaf.base.kv

import com.tencent.mmkv.MMKV


/**
 *
 * Created by leafwang on 2023/2/2.
 */
class MMKVImpl(private val mmkv: MMKV): KV {

    override fun put(key: String, value: Boolean) {
        mmkv.encode(key, value)
    }

    override fun put(key: String, value: String) {
        mmkv.encode(key, value)
    }

    override fun getBoolean(key: String, default: Boolean): Boolean {
        return mmkv.decodeBool(key, default)
    }

    override fun getString(key: String): String? {
        return mmkv.decodeString(key)
    }


}