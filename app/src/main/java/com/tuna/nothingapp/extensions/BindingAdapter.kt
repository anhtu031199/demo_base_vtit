package com.tuna.nothingapp.extensions

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("textTime")
fun TextView.setText(textTime: Long?) {
    textTime?.let {
        this.text = SimpleDateFormat("ha", Locale.ENGLISH).format(Date((textTime * 1000))).lowercase()
    }
        ?: kotlin.run {
            this.text = "--"
        }
}

@SuppressLint("SetTextI18n")
@BindingAdapter("textDouble")
fun TextView.setTextFromDouble(textDouble: Double?) {
    textDouble?.let {
        this.text = "${textDouble.toInt()}°"
    }
        ?: kotlin.run {
            this.text = "!!!"
        }
}