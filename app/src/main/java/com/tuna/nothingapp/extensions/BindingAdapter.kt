package com.tuna.nothingapp.extensions

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tuna.nothingapp.base.adapter.BaseItemModel
import com.tuna.nothingapp.base.adapter.BaseRecyclerAdapter
import com.tuna.nothingapp.utils.OnSingleClickListener
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("textTime")
fun TextView.setTimeFromText(textTime: Long?) {
    textTime?.let {
        this.text =
            SimpleDateFormat("ha", Locale.US).format(Date((textTime * 1000))).lowercase()
    }
        ?: kotlin.run {
            this.text = "--"
        }
}

@BindingAdapter("textDate")
fun TextView.setDateFromText(textDate: Long?) {
    textDate?.let {
        this.text =
            SimpleDateFormat("EEE", Locale.US).format(Date((textDate * 1000)))
    }
        ?: kotlin.run {
            this.text = "--"
        }
}

@SuppressLint("SetTextI18n")
@BindingAdapter("textTemperature")
fun TextView.setTextFromDouble(textTemperature: Double?) {
    textTemperature?.let {
        this.text = "${textTemperature.toInt()}°"
    }
        ?: kotlin.run {
            this.text = "!!!"
        }
}

@BindingAdapter("bindItems")
fun RecyclerView.bindRecyclerView(items: List<BaseItemModel>?) {
    if (items == null || items.isEmpty()) return

    val mAdapter = if (adapter != null && adapter is BaseRecyclerAdapter) {
        adapter as BaseRecyclerAdapter
    } else {
        val baseAdapter = BaseRecyclerAdapter()
        adapter = baseAdapter
        baseAdapter
    }
    mAdapter.setItems(items)
}

@BindingAdapter("onSingleClick")
fun View.setOnSingleClickListener(clickListener: View.OnClickListener?) {
    clickListener?.also {
        setOnClickListener(OnSingleClickListener(it))
    } ?: setOnClickListener(null)
}