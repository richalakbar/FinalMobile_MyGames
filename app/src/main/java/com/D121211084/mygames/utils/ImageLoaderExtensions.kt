package com.D121211084.mygames.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.D121211084.mygames.R

fun ImageView.loadImage(url: String) =
    Glide.with(this)
        .load(url)
        .apply(RequestOptions.placeholderOf(R.drawable.ic_placeholder).error(R.drawable.ic_placeholder))
        .into(this)