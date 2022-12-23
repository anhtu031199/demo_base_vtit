package com.tuna.nothingapp.base.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.tuna.nothingapp.BR
import com.tuna.nothingapp.extensions.orDefault

class BaseRecyclerAdapter : RecyclerView.Adapter<BaseViewHolder>() {

    private var itemList: MutableList<BaseItemModel> = mutableListOf()
    private val viewTypeToLayoutId: MutableMap<Int, Int> = mutableMapOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            viewTypeToLayoutId[viewType].orDefault(),
            parent,
            false
        )
        return BaseViewHolder(binding)
    }

    override fun getItemViewType(position: Int): Int {
        val item = itemList[position]
        if (!viewTypeToLayoutId.containsKey(item.viewType)) {
            viewTypeToLayoutId[item.viewType] = item.layoutId
        }
        return item.viewType
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

    fun setItems(items: List<BaseItemModel>?) {
        val diffUtil = DiffCallback(itemList, items.orEmpty())
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        itemList.clear()
        itemList.addAll(items.orEmpty())
        diffResult.dispatchUpdatesTo(this)
    }
}

class BaseViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: BaseItemModel) {
        binding.setVariable(BR.itemUi, item)
    }
}
