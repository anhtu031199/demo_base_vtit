package com.tuna.nothingapp.ui.viewPager.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tuna.nothingapp.data.remote.response.Hourly
import com.tuna.nothingapp.databinding.ItemHourlyBinding
//
//class HourlyRecyclerAdapter(private val data: List<Hourly>): RecyclerView.Adapter<HourlyRecyclerAdapter.ViewHolder>() {
//
//    inner class ViewHolder(val binding: ItemHourlyBinding): RecyclerView.ViewHolder(binding.root){
//        fun bind(item: Hourly){
//            binding.itemUi = item
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//
//        val listItemBinding = ItemHourlyBinding.inflate(inflater, parent, false)
//
//        return ViewHolder(listItemBinding)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(data[position])
//    }
//
//    override fun getItemCount(): Int = 24
//}