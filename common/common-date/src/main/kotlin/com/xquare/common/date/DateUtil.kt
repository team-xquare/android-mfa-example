package com.xquare.common.date

import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime

fun String.toInstant(timeZone: TimeZone = TimeZone.currentSystemDefault()): Instant =
    this.toLocalDateTime().toInstant(timeZone)
