package com.leaf.wanandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.therouter.TheRouter
import com.therouter.router.Route

@Route(path = "http://wanandroid.com/main")
class MainActivity : AppCompatActivity() {

    private lateinit var mViewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewPager()
    }

    private fun initViewPager() {

        mViewPager = findViewById(R.id.viewPager)

        val homeFragment = TheRouter.build("http://wanandroid.com/home").createFragment<Fragment>()!!
        val collectFragment = TheRouter.build("http://wanandroid.com/collect_article").createFragment<Fragment>()!!

        val viewPagerAdapter = ViewPagerAdapter(this, listOf(homeFragment, collectFragment))
        mViewPager.adapter = viewPagerAdapter
    }
}