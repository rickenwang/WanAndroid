package com.leaf.feature.banner.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.leaf.feature.banner.R
import com.leaf.feature.common.services.banner.BannerViewDelegate
import com.youth.banner.Banner
import com.youth.banner.adapter.BannerAdapter
import com.youth.banner.indicator.CircleIndicator
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class BannerView(context: Context): Banner<String, WanAndroidBannerAdapter>(context),
    BannerViewDelegate {

    init {
        val adapter = WanAndroidBannerAdapter(emptyList())
        this.setAdapter(adapter)
            .setIndicator(CircleIndicator(context))
    }

    override fun bannerView(): View {
        return this
    }

    override fun loadBanner(fragment: Fragment) {

        val viewModel = ViewModelProvider(fragment).get(BannerViewModel::class.java)
        fragment.lifecycleScope.launch {
            viewModel.mBannerFlow.collect {

                when(it) {

                    is BannerViewState.Success -> {
                        adapter.setDatas(it.banner.map {
                            it.imagePath
                        })
                    }

                    else -> {

                    }

                }
            }
        }
        fragment.lifecycleScope.launch {
            viewModel.listBanner()
        }
    }

}

class WanAndroidBannerAdapter(mDatas: List<String>): BannerAdapter<String, BannerViewHolder>(mDatas) {

    override fun onCreateHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.banner_item, parent, false)
        return BannerViewHolder(view)
    }

    override fun onBindView(holder: BannerViewHolder, data: String, position: Int, size: Int) {
        holder.refresh(data)
    }
}

class BannerViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val mBannerImageView = view.findViewById<ImageView>(R.id.iv_banner)

    fun refresh(url: String) {
        if (url.isNotEmpty()) {
            Glide.with(itemView)
                .load(url)
                .into(mBannerImageView)
        }
    }
}

