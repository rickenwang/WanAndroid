package com.leaf.base.kv

import com.tencent.mmkv.MMKV
import com.therouter.getApplicationContext

// kv 可以在需要的时候才进行初始化
// 延时初始化的方式
// 1. 在 init 块中进行初始化，单例类会生成 static 初始化块，
// 2. 在访问的方法中添加初始化代码
object KVManager {

    init {
        MMKV.initialize(getApplicationContext())
    }

    fun kv(): KV {
        return MMKVImpl(MMKV.defaultMMKV())
    }


}
