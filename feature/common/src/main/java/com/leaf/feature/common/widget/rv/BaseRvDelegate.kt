package com.leaf.feature.common.widget.rv

import android.content.Context
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

    open fun onCreateItemView(context: Context, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(context)
        return inflater.inflate(contentLayoutId, parent, false)
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): VH {
        val itemView = onCreateItemView(parent.context, parent)
        val holder = onCreateViewHolder(itemView)

        // 在 onCreateViewHolder 设置监听，而不是 onBindViewHolder
        itemView.setOnClickListener {
            val adapterPosition = holder.bindingAdapterPosition
            val item = try {
                adapter.items[adapterPosition] as T
            } catch (e: Exception) {
                null
            }

            item?.let {
                onItemClickListener?.onItemClick(holder, item)
            }
        }
        itemView.setOnLongClickListener {
            val adapterPosition = holder.bindingAdapterPosition
            val item = try {
                adapter.items[adapterPosition] as T
            } catch (e: Exception) {
                null
            }

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