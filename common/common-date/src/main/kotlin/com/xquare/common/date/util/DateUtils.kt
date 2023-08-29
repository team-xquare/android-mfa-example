package com.xquare.common.date.util

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

val now: Instant
    get() = Clock.System.now()
