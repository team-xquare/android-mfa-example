package com.xquare.domain.user.model.input

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegisterRequest(
    @SerialName("verification_code") val verificationCode: String,
    @SerialName("account_id") val accountId: String,
    @SerialName("password") val password: String,
    @SerialName("profile_file_name") val profileImageUrl: String?,
)
