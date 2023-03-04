package com.kaya.trading.gateway.enum

enum class BinanceSecurityType(var isSigned: Boolean) {
    NONE(false), TRADE(true), MARGIN(true), USER_DATA(true), USER_STREAM(false), MARKET_DATA(false)
}