package com.kaya.trading.gateway.enum

enum class BinanceEndpointEnum(var restOfUrl: String, var securityType: BinanceSecurityType, var needsTimestamp: Boolean) {
    WALLET_ALL_COINS("/sapi/v1/capital/config/getall", BinanceSecurityType.USER_DATA,true),
    MARKET_DATA_COIN("/api/v3/exchangeInfo", BinanceSecurityType.MARKET_DATA, false),
    TEST_NEW_ORDER("/api/v3/order/test", BinanceSecurityType.TRADE, needsTimestamp = true),
    NEW_ORDER("/api/v3/order", BinanceSecurityType.TRADE, needsTimestamp = true),
    QUERY_ALL_ORDERS("/api/v3/allOrders", BinanceSecurityType.TRADE, needsTimestamp = true),
    USDM_NEW_ORDER("/fapi/v1/order", BinanceSecurityType.TRADE, needsTimestamp = true)
}