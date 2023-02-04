package com.leaf.feature.common.services.server.wanandroid.adapter

import com.leaf.feature.common.services.server.wanandroid.WanAndroidResponse
import okhttp3.Request
import retrofit2.*
import java.io.IOException
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type


/**
 * 将
 */
class WanAndroidCallAdapter<T>(
    private val dataType: Type,

): CallAdapter<T, Call<WanAndroidResponse<T>>> {

    override fun responseType(): Type {
        return dataType
    }

    override fun adapt(call: Call<T>): Call<WanAndroidResponse<T>> {
        return WanAndroidCall(call)
    }
}

class WanAndroidCall<T>(val call: Call<T>): Call<WanAndroidResponse<T>> {

    override fun clone(): Call<WanAndroidResponse<T>> {
        return WanAndroidCall(call)
    }

    override fun execute(): Response<WanAndroidResponse<T>> {
        throw UnsupportedOperationException("doesn't support execute")
    }

    override fun isExecuted(): Boolean {
        return call.isExecuted
    }

    override fun cancel() {
        return call.cancel()
    }

    override fun isCanceled(): Boolean {
        return call.isCanceled
    }

    override fun request(): Request {
        return call.request()
    }

    override fun enqueue(callback: Callback<WanAndroidResponse<T>>) {
        call.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {

                val body = response.body()
                callback.onResponse(
                    this@WanAndroidCall,
                    Response.success(WanAndroidResponse.Success(body))
                )

            }

            override fun onFailure(call: Call<T>, throwable: Throwable) {

                val networkResponse = when (throwable) {
                    is IOException -> WanAndroidResponse.NetworkError(throwable)
                    else -> WanAndroidResponse.UnknownError(throwable)
                }
                callback.onResponse(this@WanAndroidCall, Response.success(networkResponse))
            }

        })
    }

}

class WanAndroidCallAdapterFactory: CallAdapter.Factory() {
    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {

        if (getRawType(returnType) != Call::class.java) {
            return null
        }

        // get the response type inside the `Call` type
        val responseType = getParameterUpperBound(0, returnType as ParameterizedType)

        if (getRawType(responseType) != WanAndroidResponse::class.java) {
            return null
        }
        val dataType = getParameterUpperBound(0, responseType as ParameterizedType)

        return WanAndroidCallAdapter<Any>(dataType)
    }
}