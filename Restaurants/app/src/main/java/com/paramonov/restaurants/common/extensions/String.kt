package com.paramonov.restaurants.common.extensions

import java.lang.RuntimeException
import java.text.SimpleDateFormat
import java.util.*

fun String.isoDateTimeConvertToDate(local: Locale = Locale("ru")): Date {
    val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", local)
    return formatter.parse(this) ?: throw RuntimeException("Date is null")
}

fun String.lowerCase() = lowercase(Locale.getDefault())
