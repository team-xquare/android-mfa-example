package com.xquare.core.common.util

import com.xquare.core.common.di.DiQualifier
import org.koin.core.qualifier.named
import org.koin.java.KoinJavaComponent.get

val isDebugEnabled: Boolean
    inline get() = get(
        clazz = Boolean::class.java,
        qualifier = named(DiQualifier.Build.DEBUG),
    )
