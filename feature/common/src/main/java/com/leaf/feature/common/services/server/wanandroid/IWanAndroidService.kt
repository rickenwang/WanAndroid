package com.leaf.feature.common.services.server.wanandroid

import com.leaf.base.network.NetworkManager
import com.leaf.feature.common.services.server.wanandroid.adapter.WanAndroidCallAdapterFactory
import com.leaf.feature.common.services.server.wanandroid.entities.ListArticleEntity
import com.leaf.feature.common.services.server.wanandroid.entities.LoginEntity
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query


/**
 *
 * Created by leafwang on 2023/2/1.
 */
interface IWanAndroidService {

    companion object {

        val service: IWanAndroidService
        private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(WanAndroidCallAdapterFactory())
            .client(NetworkManager.okClient())
            .build()

        init {
            service = retrofit.create(IWanAndroidService::class.java)
        }

        private fun baseUrl(): String {
            return "https://www.wanandroid.com"
        }

    }


    @POST("user/login")
    suspend fun login(
        @Query("username") username: String,
        @Query("password") password: String,
    ): WanAndroidResponse<LoginEntity>

    @GET("article/list/{page}/json")
    suspend fun listArticles(
        @Path("page") page: Int
    ): WanAndroidResponse<ListArticleEntity>


    @GET("lg/collect/list/{page}/json")
    suspend fun listCollectedArticles(
        @Path("page") page: Int
    ): WanAndroidResponse<ListArticleEntity>
}