package com.paramonov.restaurants.common.extensions

import java.text.SimpleDateFormat
import java.util.*

fun Date.formatToString(pattern: String, local: Locale = Locale("ru")): String {
    val df = SimpleDateFormat(pattern, local)
    return df.format(time)
}