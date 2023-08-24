package com.xquare.domain.user.model.output

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class AuthOutput(
    @SerialName("access_token") val accessToken: String,
    @SerialName("access_token_expire_at") val accessTokenExpiration: String,
    @SerialName("refresh_token") val refreshToken: String,
    @SerialName("refresh_token_expire_at") val refreshTokenExpiration: String,
    // todo converter 구현
    @SerialName("role") val role: String,
)
