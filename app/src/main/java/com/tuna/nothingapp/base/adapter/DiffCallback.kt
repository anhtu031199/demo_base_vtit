package com.tuna.nothingapp.base.adapter

import androidx.recyclerview.widget.DiffUtil

class DiffCallback(
    private val oldList: List<BaseItemModel>,
    private val newList: List<BaseItemModel>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].primaryField == newList[newItemPosition].primaryField
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}
