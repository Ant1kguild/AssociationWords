package com.example.associationwords.utils.CoilUtils

import android.widget.ImageView
import coil.api.load
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.example.associationwords.R

fun ImageView.loadImageCoil(url: String) {
    load(url) {
        crossfade(true)
        placeholder(R.drawable.ic_launcher_foreground)
        transformations(CircleCropTransformation())
        scale(Scale.FIT)
    }
}