package com.tuna.nothingapp.data.local.model

import com.tuna.nothingapp.R
import com.tuna.nothingapp.base.adapter.BaseItemModel
import com.tuna.nothingapp.data.remote.response.Hourly

data class HourlyItemUI(
    val hourly: Hourly,
    val timeZone: String,
    val onClick: (HourlyItemUI) -> Unit
) : BaseItemModel {
    val dt: Long = hourly.dt
    val icon: String = hourly.weather[0].icon
    val temp: Double = hourly.temp

    override val layoutId: Int = R.layout.item_hourly

    fun onItemClick() {
        onClick(this)
    }
}