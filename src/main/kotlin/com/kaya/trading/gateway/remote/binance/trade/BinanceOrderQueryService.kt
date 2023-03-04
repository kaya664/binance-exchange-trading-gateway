package com.kaya.trading.gateway.remote.binance.trade

import com.kaya.trading.gateway.enum.BinanceEndpointEnum
import com.kaya.trading.gateway.enum.Endpoint
import com.kaya.trading.gateway.service.HttpHandlerService
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service

@Service
class BinanceOrderQueryService(private val httpHandlerService: HttpHandlerService) {

    fun getOrdersForSymbol(coinPair: String) {
        httpHandlerService.sendRequest(
            Endpoint.BinanceEndpoint(BinanceEndpointEnum.QUERY_ALL_ORDERS, "symbol=$coinPair"), mutableMapOf(), HttpMethod.GET
        )
    }

}