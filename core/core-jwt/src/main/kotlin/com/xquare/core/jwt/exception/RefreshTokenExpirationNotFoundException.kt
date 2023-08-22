package com.xquare.core.jwt.exception

class RefreshTokenExpirationNotFoundException :
    RuntimeException("Refresh token expiration not found.")
