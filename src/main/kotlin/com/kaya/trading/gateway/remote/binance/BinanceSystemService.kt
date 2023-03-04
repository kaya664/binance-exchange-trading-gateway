package com.kaya.trading.gateway.remote.binance

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Service

@Service
class BinanceSystemService(val restTemplateBuilder: RestTemplateBuilder) {

    fun getEndpointStatus() {

    }

}