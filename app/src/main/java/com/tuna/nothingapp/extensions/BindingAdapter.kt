package com.tuna.nothingapp.extensions

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tuna.nothingapp.R
import com.tuna.nothingapp.base.adapter.BaseItemModel
import com.tuna.nothingapp.base.adapter.BaseRecyclerAdapter
import com.tuna.nothingapp.utils.OnSingleClickListener
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("textTime", "timeZone")
fun TextView.setTimeFromText(textTime: Long?, timeZone: String?) {
    textTime?.let {
        val sdf = SimpleDateFormat("ha", Locale.getDefault())
        timeZone?.let {
            sdf.timeZone = TimeZone.getTimeZone(timeZone)
        }
        this.text =
            sdf.format(Date((textTime * 1000))).lowercase()
    }
        ?: kotlin.run {
            this.text = "--"
        }
}

@BindingAdapter("textDateOfWeek")
fun TextView.setDateOfWeekFromText(textDate: Long?) {
    textDate?.let {
        this.text =
            SimpleDateFormat("EEE", Locale.getDefault()).format(Date((textDate * 1000)))
    }
        ?: kotlin.run {
            this.text = "--"
        }
}

@BindingAdapter("textDate")
fun TextView.setDateFromText(textDate: Long?) {
    textDate?.let {
        this.text =
            SimpleDateFormat("EEEE, d MMMM", Locale.getDefault()).format(Date((textDate * 1000)))
    }
        ?: kotlin.run {
            this.text = "--"
        }
}

@BindingAdapter("textDateOfMonth")
fun TextView.setDateOfMonthFromText(textDate: Long?) {
    textDate?.let {
        this.text =
            SimpleDateFormat("d MMM", Locale.getDefault()).format(Date((textDate * 1000)))
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
            this.text = "--°"
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
    this.isNestedScrollingEnabled = false
    this.setHasFixedSize(false)
}

@BindingAdapter("onSingleClick")
fun View.setOnSingleClickListener(clickListener: View.OnClickListener?) {
    clickListener?.also {
        setOnClickListener(OnSingleClickListener(it))
    } ?: setOnClickListener(null)
}

@BindingAdapter("isSelected")
fun TextView.isSelected(isSelected: Boolean) {
    this.isSelected = isSelected
}

@BindingAdapter("isShow")
fun View.isShow(isShow: Boolean) {
    this.visibility = if (isShow) View.VISIBLE else View.GONE
}

@BindingAdapter("loadImg")
fun ImageView.loadImage(loadImg: String?) {
    loadImg?.let {
        val icon = context.resources.getIdentifier("ic_$loadImg", "drawable", context.packageName)
        if (icon != 0) {
            Glide.with(context).load(icon).fitCenter().into(this)
        } else {
            Glide.with(context).load(R.drawable.ic_50d).fitCenter().into(this)
        }
    } ?: run {
        Glide.with(context).load(R.drawable.ic_50d).fitCenter().into(this)
    }
}

@BindingAdapter("backgroundImg")
fun ImageView.setBackground(backgroundImg: String?) {
    backgroundImg?.let {
        val icon: Int = when (backgroundImg) {
            "01d", "02d", "03d", "04d", "09d", "10d", "11d", "13d", "50d" -> R.drawable.bg_d
            "01n", "02n", "03n", "04n", "09n", "10n", "11n", "13n", "50n" -> R.drawable.bg_n
            else -> {
                R.drawable.bg_n
            }
        }
        if (icon != 0) {
            Glide.with(context).load(icon).fitCenter().into(this)
        } else {
            Glide.with(context).load(R.drawable.bg_n).fitCenter().into(this)
        }
    } ?: run {
        Glide.with(context).load(R.drawable.bg_n).fitCenter().into(this)
    }
}

@BindingAdapter("textCapitalize")
fun TextView.toCapitalize(text: String?){
    this.text = text?.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
}