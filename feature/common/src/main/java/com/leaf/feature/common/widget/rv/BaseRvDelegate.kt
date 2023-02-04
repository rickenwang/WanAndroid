package com.leaf.feature.common.widget.rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.drakeet.multitype.ItemViewBinder

/**
 *
 */
abstract class BaseRvDelegate<T : IDiffItem, VH: BaseViewHolder>(@LayoutRes open val contentLayoutId: Int) :
    ItemViewBinder<T, VH>() {

    var onItemClickListener: OnItemClickListener<T>? = null
    var onItemLongClickListener: OnItemLongClickListener<T>? = null

    abstract fun onCreateViewHolder(item: View): VH

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): VH {
        val itemView = inflater.inflate(contentLayoutId, parent, false)
        val holder = onCreateViewHolder(itemView)
        val adapterPosition = holder.bindingAdapterPosition
        val item = try {
            adapter.items[adapterPosition] as T
        } catch (e: Exception) {
            null
        }

        // 在 onCreateViewHolder 设置监听，而不是 onBindViewHolder
        itemView.setOnClickListener {
            item?.let {
                onItemClickListener?.onItemClick(holder, item)
            }
        }
        itemView.setOnLongClickListener {
            return@setOnLongClickListener if (item != null) {
                onItemLongClickListener?.onItemLongClick(holder, item)
                true
            } else {
                false
            }
        }

        return holder
    }

    interface OnItemClickListener<T : IDiffItem> {
        fun onItemClick(holder: BaseViewHolder, item: T)
    }

    interface OnItemLongClickListener<T : IDiffItem> {
        fun onItemLongClick(holder: BaseViewHolder, item: T)
    }
}