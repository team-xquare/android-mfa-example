package com.xquare.core.network.model

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class Meal(
    @SerialName("date") val date: Instant,
)
