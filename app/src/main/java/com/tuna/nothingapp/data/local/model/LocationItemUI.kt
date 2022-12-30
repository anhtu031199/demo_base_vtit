package com.tuna.nothingapp.data.local.model

import com.tuna.nothingapp.R
import com.tuna.nothingapp.base.adapter.BaseItemModel
import com.tuna.nothingapp.data.local.entity.Location
import com.tuna.nothingapp.data.remote.response.Daily

data class LocationItemUI(
    val location: Location,
    val onClick: (LocationItemUI) -> Unit
) : BaseItemModel {
    val main: String? = location.main
    val isShow: Boolean? = location.isCurrentLocate
    val icon: String? = location.icon
    val maxTemp: Int = location.maxTemp?.toInt() ?: 0
    val minTemp: Int = location.minTemp?.toInt() ?: 0
    val temp: Double? = location.temp?.toDouble()
    val name: String? = location.name

    override val layoutId: Int = R.layout.item_location

    fun onItemClick() {
        onClick(this)
    }
}