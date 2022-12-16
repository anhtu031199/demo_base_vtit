package com.tuna.nothingapp.base.adapter

import androidx.annotation.LayoutRes

interface BaseItemModel {
    val primaryField: Any
    get() = DEFAULT_ID

    @get:LayoutRes
    val layoutId: Int
    val viewType: Int
    get() = DEFAULT_TYPE

    override fun equals(other: Any?): Boolean

    companion object {
        const val DEFAULT_TYPE = 0
        const val DEFAULT_ID = 0
    }
}