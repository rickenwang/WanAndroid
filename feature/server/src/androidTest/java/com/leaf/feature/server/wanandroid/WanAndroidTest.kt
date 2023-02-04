package com.leaf.feature.server.wanandroid

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.leaf.feature.common.services.server.wanandroid.WanAndroidResponse
import com.leaf.feature.server.provideServerService
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith


/**
 *
 * Created by leafwang on 2023/2/1.
 */
@RunWith(AndroidJUnit4::class)
class WanAndroidTest {

    private val mWanAndroidService = provideServerService().wanAndroidService()

    @Test
    fun testLogin() = runBlocking {

        val loginEntity = mWanAndroidService
            .login("davoswang", "gz2966GZR")

        Assert.assertEquals(true, loginEntity is WanAndroidResponse.Success)
    }

    @Test
    fun testListArticle() = runBlocking {

        mWanAndroidService
            .login("davoswang", "gz2966GZR")
        val listArticleEntity = mWanAndroidService
            .listArticles(0)

        Assert.assertEquals(true, listArticleEntity is WanAndroidResponse.Success)
    }

    @Test
    fun testListCollectedArticles() = runBlocking {

        val loginEntity = mWanAndroidService
            .login("davoswang", "gz2966GZR")

        val listCollectedArticlesEntity =mWanAndroidService
            .listCollectedArticles(0)

        Assert.assertEquals(true, listCollectedArticlesEntity is WanAndroidResponse.Success)
    }
}