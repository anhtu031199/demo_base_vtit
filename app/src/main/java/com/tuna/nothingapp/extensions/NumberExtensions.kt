package com.tuna.nothingapp.extensions

const val DEFAULT_STRING = ""
const val DEFAULT_INT = 0
const val DEFAULT_LONG = 0L
const val DEFAULT_FLOAT = 0.0F
const val DEFAULT_DOUBLE = 0.0
const val DEFAULT_BOOLEAN = false

fun Int?.isNull(): Boolean = this == null

fun Int?.isNotNull(): Boolean = this.isNull().not()

fun Int?.isNullOrZero(): Boolean = this.isNull() || this == 0

fun Int?.isNotNullOrZero(): Boolean = this.isNullOrZero().not()

fun Int?.orDefault() = this ?: DEFAULT_INT

fun Long?.orDefault() = this ?: DEFAULT_LONG

fun Float?.orDefault() = this ?: DEFAULT_FLOAT

fun String?.orDefault() = this ?: DEFAULT_STRING
