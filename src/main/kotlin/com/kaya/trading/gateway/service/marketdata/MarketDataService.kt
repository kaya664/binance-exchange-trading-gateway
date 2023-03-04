package com.kaya.trading.gateway.service.marketdata

import com.kaya.trading.gateway.remote.binance.BinanceMarketDataService
import org.springframework.stereotype.Service

@Service
class MarketDataService(private val binanceMarketDataService: BinanceMarketDataService) {

    fun getMarketData(coinPair: String) {
        binanceMarketDataService.getMarketData(coinPair)
    }

}