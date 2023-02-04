package com.leaf.wanandroid

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


/**
 *
 * Created by leafwang on 2023/2/4.
 */
class ViewPagerAdapter(mFragmentActivity: FragmentActivity, private val mFragments: List<Fragment>)
    : FragmentStateAdapter(mFragmentActivity) {

    override fun getItemCount()= mFragments.size

    override fun createFragment(position: Int): Fragment {
        return mFragments[position]
    }


}