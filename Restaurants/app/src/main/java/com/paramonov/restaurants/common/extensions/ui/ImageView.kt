package com.paramonov.restaurants.common.extensions.ui

import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.paramonov.restaurants.R
import com.squareup.picasso.Picasso

fun ImageView.setDrawableFromResource(@DrawableRes id: Int) {
    setImageDrawable(ContextCompat.getDrawable(context, id))
}

fun ImageView.loadByUrl(imgUrl: String, @DrawableRes imgIdOnError: Int) {
    if (imgUrl.isNotBlank()) {
        Picasso.get().load(imgUrl).error(imgIdOnError).into(this)
    }
}