package com.kaya.trading.gateway.remote.binance

import com.kaya.trading.gateway.enum.BinanceEndpointEnum
import com.kaya.trading.gateway.enum.Endpoint
import com.kaya.trading.gateway.service.HttpHandlerService
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service

@Service
class BinanceWalletService(val httpHandlerService: HttpHandlerService) {

    fun getAllCoinInformationsForUser() {
        var map: MutableMap<String, String> = mutableMapOf()
        httpHandlerService.sendRequest(
            Endpoint.BinanceEndpoint(BinanceEndpointEnum.WALLET_ALL_COINS, ""),
            map,
            HttpMethod.GET
        )
    }

}