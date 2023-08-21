package com.xquare.common.project

import com.xquare.common.di.DiQualifier
import org.koin.core.qualifier.named
import org.koin.java.KoinJavaComponent.get

val isDebugEnabled: Boolean
    inline get() = get(
        clazz = Boolean::class.java,
        qualifier = named(DiQualifier.Build.DEBUG),
    )

