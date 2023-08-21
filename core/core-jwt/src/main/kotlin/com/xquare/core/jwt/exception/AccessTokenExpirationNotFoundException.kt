package com.xquare.core.jwt.exception

class AccessTokenExpirationNotFoundException :
    RuntimeException("Access token expiration not found.")
