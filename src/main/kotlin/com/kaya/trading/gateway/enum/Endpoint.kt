package com.kaya.trading.gateway.enum

sealed class Endpoint() {
    data class BinanceEndpoint(val endpoint: BinanceEndpointEnum, val urlParams: String?, val baseUrl: String = "https://api.binance.com", val apiSecretKey: String = "", val apiClientKey: String = ""): Endpoint()
}