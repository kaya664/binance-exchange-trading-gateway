package com.kaya.trading.gateway.util

import com.kaya.trading.gateway.enum.Endpoint
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RequestProviderContext {

    @Autowired
    private lateinit var binanceRequestProvider: BinanceRequestProvider

    fun getContext(endpoint: Endpoint): IHttpRequestProvider {
        var httpRequestProvider = when (endpoint) {
            is Endpoint.BinanceEndpoint -> {
                binanceRequestProvider
            }
        }
        return httpRequestProvider
    }

}