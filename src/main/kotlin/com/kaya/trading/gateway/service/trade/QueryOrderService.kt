package com.kaya.trading.gateway.service.trade

import com.kaya.trading.gateway.remote.binance.trade.BinanceOrderQueryService
import org.springframework.stereotype.Service

@Service
class QueryOrderService(private val binanceOrderQueryService: BinanceOrderQueryService) {

    fun getOrdersForSymbol(coinPair: String) {
        binanceOrderQueryService.getOrdersForSymbol(coinPair)
    }

}