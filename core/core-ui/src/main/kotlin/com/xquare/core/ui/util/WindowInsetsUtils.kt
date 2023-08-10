package com.xquare.core.ui.util

import android.annotation.SuppressLint
import android.content.Context

data class SystemBarsHeight(
    val statusBarHeight: Int,
    val navigationBarHeight: Int,
)

@SuppressLint("InternalInsetResource", "DiscouragedApi")
fun measureNavigationBarHeight(context: Context): Int {
    val resourceId = context.resources.getIdentifier("navigation_bar_height", "dimen", "android")

    check(resourceId >= 0)

    return context.resources.getDimensionPixelSize(resourceId)
}

fun Context?.measureNavigationBarHeight(): Int {
    requireNotNull(this)

    return measureNavigationBarHeight(this)
}
