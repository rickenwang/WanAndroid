package com.leaf.feature.common.services.server.wanandroid

import java.io.IOException

/**
 *
 * Created by jeremywang on 2023/2/1.
 */
sealed class WanAndroidResponse<out T> {
    
    // 请求成功
    data class Success<out T>(val result: T?): WanAndroidResponse<T>()

    // 后台报错
    // data class BackendError(val error: WanAndroidError): WanAndroidResponse<Nothing>()

    // 网络错误
    data class NetworkError(val error: IOException): WanAndroidResponse<Nothing>()

    // 未知错误
    data class UnknownError(val error: Throwable): WanAndroidResponse<Nothing>()
    
}

val <T> WanAndroidResponse<T>.data: T
    get() = when (this) {
        is WanAndroidResponse.Success -> this.result?: throw IllegalAccessException("data is null")
        is WanAndroidResponse.NetworkError -> throw this.error
        is WanAndroidResponse.UnknownError -> throw this.error
    }
