package com.leaf.feature.common.widget.rv

import androidx.recyclerview.widget.DiffUtil
import com.drakeet.multitype.MultiTypeAdapter

class DiffMultiTypeAdapter : MultiTypeAdapter() {
    val header: MutableList<IDiffItem> = mutableListOf()
    val footer: MutableList<IDiffItem> = mutableListOf()
    val content: MutableList<IDiffItem> = mutableListOf()

    private val oldItems: MutableList<IDiffItem> = emptyList<IDiffItem>().toMutableList()
    fun setContentData(newContent: List<IDiffItem>) {
        content.clear()
        content.addAll(newContent)
        val list = buildNewList()
        items = list
        val diffCallback = XDiffCallback(oldItems, list)
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(diffCallback)
        diffResult.dispatchUpdatesTo(this)
        updateOldList(list)
    }

    fun addHeader(h: IDiffItem){
        header.add(h)
        val list = buildNewList()
        items = list
        notifyItemRangeInserted(header.size - 1, 1)
        updateOldList(list)
    }

    fun removeHeader(index: Int){
        header.removeAt(index)
        val list = buildNewList()
        items = list
        notifyItemRangeRemoved(index, 1)
        updateOldList(list)
    }

    fun addFooter(f: IDiffItem){
        footer.add(f)
        val list = buildNewList()
        items = list
        notifyItemRangeInserted(items.size - 1, 1)
        updateOldList(list)
    }

    fun updateFooter(index: Int, f: IDiffItem){
        if(footer[index] == f){
            return
        }

        footer.removeAt(index)
        footer.add(index, f)
        val list = buildNewList()
        items = list
        notifyItemChanged(items.size - (footer.size - index))
        updateOldList(list)
    }

    fun removeFooter(index: Int){
        footer.removeAt(index)
        val list = buildNewList()
        items = list
        notifyItemRangeRemoved(items.size - (footer.size - index), 1)
        updateOldList(list)
    }

    fun removeAllHeader(){
        val headerCount = header.size
        header.clear()
        val list = buildNewList()
        items = list
        notifyItemRangeRemoved(0, headerCount)
        updateOldList(list)
    }

    fun removeAllFooter(){
        val footerCount = footer.size
        footer.clear()
        val list = buildNewList()
        items = list
        notifyItemRangeRemoved(oldItems.size - footerCount, footerCount)
        updateOldList(list)
    }

    fun isContentEmpty(): Boolean{
        return content.isEmpty()
    }

    fun notifyItemChanged(item: IDiffItem){
        val index = items.indexOf(item)
        if(index != -1) {
            notifyItemChanged(index)
        }
    }

    private fun buildNewList(): List<IDiffItem>{
        val list = mutableListOf<IDiffItem>()
        list.addAll(header)
        list.addAll(content)
        list.addAll(footer)
        return list
    }

    private fun updateOldList(list: List<IDiffItem>){
//        oldItems.clear()
//        for (i in list) {
//            oldItems.add(i.deepCopy())
//        }
        oldItems.clear()
        oldItems.addAll(list)
    }

    internal class XDiffCallback(private val oldList: List<IDiffItem>, private val newList: List<IDiffItem>) :
        DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            if(oldList.size <= oldItemPosition || newList.size <= newItemPosition)
                return false

            val old = oldList[oldItemPosition]
            val new = newList[newItemPosition]

            // 类型相同却ID相同
            // 类型用于区分不同类型的item、id用来区分同类型的item
            return old.javaClass == new.javaClass
                    && old.id() == new.id()
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            if(oldList.size <= oldItemPosition || newList.size <= newItemPosition)
                return false

            val old = oldList[oldItemPosition]
            val new = newList[newItemPosition]
            return new.contentsEqual(old)
        }

        override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
            return if(oldList.size <= oldItemPosition || newList.size <= newItemPosition) {
                super.getChangePayload(oldItemPosition, newItemPosition)
            } else {
                val old = oldList[oldItemPosition]
                val new = newList[newItemPosition]
                new.payload(old)
            }
        }
    }
}