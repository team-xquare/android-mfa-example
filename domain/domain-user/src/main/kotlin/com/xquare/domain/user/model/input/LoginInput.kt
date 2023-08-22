package com.xquare.domain.user.model.input

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginInput(
    @SerialName("account_id") val accountId: String,
    @SerialName("password") val password: String,
    // todo device token 관련 core module, typealias 생성 필요
    @SerialName("device_token") val deviceToken: String,
)
