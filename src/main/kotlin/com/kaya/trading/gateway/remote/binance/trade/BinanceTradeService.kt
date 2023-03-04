package com.kaya.trading.gateway.remote.binance.trade

import com.kaya.trading.gateway.enum.BinanceEndpointEnum
import com.kaya.trading.gateway.enum.Endpoint
import com.kaya.trading.gateway.remote.binance.request.NewBinanceOrderRequest
import com.kaya.trading.gateway.service.HttpHandlerService
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.math.RoundingMode

@Service
class BinanceTradeService(private val httpHandlerService: HttpHandlerService) {

    fun createNewTestOrder(coinPair: String) {
        httpHandlerService.sendRequest(
            Endpoint.BinanceEndpoint(
                BinanceEndpointEnum.TEST_NEW_ORDER,
                "symbol=$coinPair&type=MARKET&side=BUY&quantity=100000"
            ), mutableMapOf(), HttpMethod.POST
        )
    }

    fun createNewOrder(newBinanceOrderRequest: NewBinanceOrderRequest) {
        try {
            var action = ""
            if (newBinanceOrderRequest.action.contains("BUY") or newBinanceOrderRequest.action.contains("Long")) {
                action = "BUY"
            } else if (newBinanceOrderRequest.action.contains("SELL") or newBinanceOrderRequest.action.contains("Short")) {
                action = "SELL"
            }
            var quantity = when (action) {
                "BUY" -> newBinanceOrderRequest.contractCount
                "SELL" -> newBinanceOrderRequest.contractCount - (newBinanceOrderRequest.contractCount * BigDecimal("0.001"))
                else -> throw Exception("Unsupported Order Action")
            }
            quantity = quantity.setScale(1, RoundingMode.DOWN)
            httpHandlerService.sendRequest(
                Endpoint.BinanceEndpoint(
                    endpoint = BinanceEndpointEnum.NEW_ORDER,
                    urlParams = "symbol=${newBinanceOrderRequest.coinPair}&type=MARKET&side=${action}&quantity=${quantity}",
                    apiSecretKey = newBinanceOrderRequest.apiSecretKey.apiSecretKey,
                    apiClientKey = newBinanceOrderRequest.apiSecretKey.apiClientKey
                ), mutableMapOf(), HttpMethod.POST
            )
        } catch (e: Exception) {
            println(e.message)
        }
    }

    fun createNewPerpetualOrder(newBinanceOrderRequest: NewBinanceOrderRequest) {
        try {
            var action = ""
            if (newBinanceOrderRequest.action.contains("BUY") or newBinanceOrderRequest.action.contains("Long")) {
                action = "BUY"
            } else if (newBinanceOrderRequest.action.contains("SELL") or newBinanceOrderRequest.action.contains("Short")) {
                action = "SELL"
            }
            var quantity = when (action) {
                "BUY" -> newBinanceOrderRequest.contractCount
                "SELL" -> newBinanceOrderRequest.contractCount
                else -> throw Exception("Unsupported Order Action")
            }
            quantity = quantity.setScale(1, RoundingMode.DOWN)
            httpHandlerService.sendRequest(
                Endpoint.BinanceEndpoint(
                    endpoint = BinanceEndpointEnum.USDM_NEW_ORDER,
                    urlParams = "symbol=${newBinanceOrderRequest.coinPair}&type=MARKET&side=${action}&quantity=${quantity}",
                    baseUrl = "https://fapi.binance.com",
                    apiSecretKey = newBinanceOrderRequest.apiSecretKey.apiSecretKey,
                    apiClientKey = newBinanceOrderRequest.apiSecretKey.apiClientKey
                ), mutableMapOf(), HttpMethod.POST
            )
        } catch (e: Exception) {
            println(e.message)
        }
    }

}