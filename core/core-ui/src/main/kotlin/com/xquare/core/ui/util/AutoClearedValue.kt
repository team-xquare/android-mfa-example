package com.xquare.core.ui.util

import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * referenced from [google GithubBrowserSample](https://github.com/android/architecture-components-samples/blob/master/GithubBrowserSample/app/src/main/java/com/android/example/github/util/AutoClearedValue.kt)
 */
internal class AutoClearedValue<T : Any>(
    val fragment: Fragment,
) : ReadWriteProperty<Fragment, T> {

    private var _value: T? = null

    init {
        fragment.lifecycle.addObserver(
            object : DefaultLifecycleObserver {
                override fun onCreate(owner: LifecycleOwner) {
                    fragment.viewLifecycleOwnerLiveData.observe(fragment) { viewLifecycleOwner ->
                        viewLifecycleOwner?.lifecycle?.addObserver(
                            object : DefaultLifecycleObserver {
                                override fun onDestroy(owner: LifecycleOwner) {
                                    _value = null
                                }
                            },
                        )
                    }
                }
            },
        )
    }

    override fun getValue(
        thisRef: Fragment,
        property: KProperty<*>,
    ): T {
        return _value ?: throw IllegalStateException(
            "should never call auto-cleared-value get when it might not be available",
        )
    }

    override fun setValue(
        thisRef: Fragment,
        property: KProperty<*>,
        value: T,
    ) {
        _value = value
    }
}

internal fun <T : Any> Fragment.autoCleared() = AutoClearedValue<T>(this)
