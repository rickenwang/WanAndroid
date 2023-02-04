package com.leaf.base.network

import com.leaf.base.network.interceptor.RetryInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit


/**
 *
 * Created by leafwang on 2023/2/2.
 */
object NetworkManager {

    private val mOkHttpClientGlobal: OkHttpClient

    // 编译为 class 文件时，等价于 java 的 static 初始化块
    // 只会在第一次访问 NetworkManager 时才会初始化
    // 所以这里天然就是延时初始化的最佳实践
    init {

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        // 初始化okhttp
        mOkHttpClientGlobal = OkHttpClient.Builder()
            .addInterceptor(RetryInterceptor())
            .addInterceptor(logging)
            .cookieJar(CookieJarImpl())
            .followRedirects(true)
            .readTimeout(20, TimeUnit.SECONDS)
            .build()
    }


    fun okClient() = mOkHttpClientGlobal

}