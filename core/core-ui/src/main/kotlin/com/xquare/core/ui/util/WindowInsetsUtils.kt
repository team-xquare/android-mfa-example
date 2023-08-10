package com.xquare.core.ui.util

import android.annotation.SuppressLint
import android.content.Context

data class SystemBarsHeight(
    val statusBarHeight: Int,
    val navigationBarHeight: Int,
)

@SuppressLint("InternalInsetResource", "DiscouragedApi")
fun measureSystemNavigationBarHeight(context: Context): Int {
    val resId = context.resources.getIdentifier("navigation_bar_height", "dimen", "android")

    check(resId > 0)

    return context.resources.getDimensionPixelSize(resId)
}
}

val Context?.measuredSystemNavigationBarHeight: Int
    get() {
        requireNotNull(this)
        return measureSystemNavigationBarHeight(this)
    }
