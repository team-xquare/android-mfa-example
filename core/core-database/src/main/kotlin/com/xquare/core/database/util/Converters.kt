package com.xquare.core.database.util

import androidx.room.TypeConverter
import kotlinx.datetime.Instant

internal class InstantConverter {

    @TypeConverter
    fun epochMillisecondsToInstant(value: Long?): Instant? =
        value?.let(Instant::fromEpochMilliseconds)

    @TypeConverter
    fun instantToEpochMilliseconds(value: Instant?): Long? =
        value?.let(Instant::toEpochMilliseconds)
}
