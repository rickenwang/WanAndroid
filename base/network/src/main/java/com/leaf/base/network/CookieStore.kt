package com.leaf.base.network

import okhttp3.Cookie
import java.util.concurrent.ConcurrentHashMap


/**
 * Cookie 的二级缓存
 *
 * Created by leafwang on 2023/2/2.
 */
object CookieStore {

    private val cookies = ConcurrentHashMap<String, List<Cookie>>()

    fun saveCookie(host: String, cookie: List<Cookie>) {
        cookies[host] = cookie
    }

    fun loadCookie(host: String): List<Cookie>? {
        return cookies[host]
    }

}