package com.xquare.core.ui.di

import org.koin.core.module.Module
import org.koin.dsl.module

val uiModule: Module
    inline get() = module {}
