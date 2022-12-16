package com.tuna.nothingapp.ui.viewPager.data

import com.tuna.nothingapp.R
import com.tuna.nothingapp.base.adapter.BaseItemModel
import com.tuna.nothingapp.data.remote.response.Daily
import com.tuna.nothingapp.data.remote.response.Hourly

data class DailyItemUI(
    val daily: Daily,
    val onClick: (DailyItemUI) -> Unit
) : BaseItemModel {
    val dt: Long = daily.dt
    val maxTemp: Double = daily.temp.max
    val minTemp: Double = daily.temp.min

    override val layoutId: Int = R.layout.item_daily

    fun onItemClick() {
        onClick(this)
    }
}