package com.tuna.nothingapp.extensions

import android.content.Context
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

fun Context.showToast(text: String, duration: Int = Toast.LENGTH_SHORT) {
    if (text.isEmpty()) return

    Toast.makeText(this, text, duration).show()
}
