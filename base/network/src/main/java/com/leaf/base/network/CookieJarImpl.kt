package com.leaf.base.network

import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl


/**
 *
 * Created by leafwang on 2023/2/2.
 */
class CookieJarImpl: CookieJar {

    override fun saveFromResponse(url: HttpUrl, cookies: MutableList<Cookie>) {
        CookieStore.saveCookie(url.host(), cookies)
    }

    override fun loadForRequest(url: HttpUrl): MutableList<Cookie> {
        val cookie = CookieStore.loadCookie(url.host())
        return cookie?.toMutableList()?: mutableListOf()
    }
}