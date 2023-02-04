package com.leaf.base.network.interceptor

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.lang.Exception

class RetryInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()
        val retryStrategy = RetryStrategy(3)
        var count = 0

        while (true) {
            count++
            try {
                return process(chain, request)
            } catch (exception: Exception) {
                if (!retryStrategy.shouldRetry(count, exception)) {
                    throw exception
                }
            }
        }
    }

    private fun process(chain: Interceptor.Chain, request: Request): Response {

        return chain.proceed(request)
    }
}

class RetryStrategy(
    private val mMaxCount:Int = 3
) {
    fun shouldRetry(count: Int, exception: Exception): Boolean {
        return count < mMaxCount && exception is IOException
    }
}