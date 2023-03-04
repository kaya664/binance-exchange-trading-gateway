package com.kaya.trading.gateway.remote.binance

import com.kaya.trading.gateway.enum.BinanceEndpointEnum
import com.kaya.trading.gateway.enum.Endpoint
import com.kaya.trading.gateway.service.HttpHandlerService
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service

@Service
class BinanceMarketDataService(val httpHandlerService: HttpHandlerService) {

    fun getMarketData(coinPair: String) {
        httpHandlerService.sendRequest(
            Endpoint.BinanceEndpoint(
                BinanceEndpointEnum.MARKET_DATA_COIN,
                "symbol=$coinPair"
            ), mutableMapOf(), HttpMethod.GET
        )
    }

}