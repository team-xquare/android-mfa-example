package com.xquare.core.ui.util

import android.annotation.SuppressLint
import android.content.Context

data class SystemBarsHeight(
    val statusBarHeight: Int,
    val navigationBarHeight: Int,
)

fun measureSystemBarsHeight(context: Context): SystemBarsHeight = SystemBarsHeight(
    statusBarHeight = context.measureSystemBarHeightOf(SystemBarHeight.STATUS_BAR),
    navigationBarHeight = context.measureSystemBarHeightOf(SystemBarHeight.NAVIGATION_BAR),
)

private enum class SystemBarHeight(
    val value: String,
) {
    STATUS_BAR("status_bar_height"), NAVIGATION_BAR("navigation_bar_height"),
}

private fun Context.measureSystemBarHeightOf(type: SystemBarHeight): Int {
    val resId = getAndroidDimenIdOf(type.value)
    return resources.getDimensionPixelSize(resId)
}

@SuppressLint("InternalInsetResource", "DiscouragedApi")
private fun Context.getAndroidDimenIdOf(name: String): Int {
    val resId = resources.getIdentifier(name, "dimen", "android")
    check(resId > 0)
    return resId
}

val Context?.measuredSystemNavigationBarHeight: Int
    get() {
        requireNotNull(this)
        return this.measureSystemBarHeightOf(SystemBarHeight.NAVIGATION_BAR)
    }

val Context?.measuredSystemStatusBarHeight: Int
    get() {
        requireNotNull(this)
        return this.measureSystemBarHeightOf(SystemBarHeight.STATUS_BAR)
    }

val Context?.measuredSystemBarsHeight: SystemBarsHeight
    get() {
        requireNotNull(this)
        return measureSystemBarsHeight(this)
    }
