package com.tuna.nothingapp.ui.viewPager.data

import com.tuna.nothingapp.R
import com.tuna.nothingapp.base.adapter.BaseItemModel
import com.tuna.nothingapp.data.remote.response.Hourly

data class HourlyItemUI(
    val hourly: Hourly,
    val onClick: (HourlyItemUI) -> Unit
) : BaseItemModel {
    val dt: Long = hourly.dt
    val temp: Double = hourly.temp

    override val layoutId: Int = R.layout.item_hourly

    fun onItemClick() {
        onClick(this)
    }
}