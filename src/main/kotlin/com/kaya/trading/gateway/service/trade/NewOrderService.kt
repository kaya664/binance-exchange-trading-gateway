package com.kaya.trading.gateway.service.trade

import com.kaya.trading.gateway.controller.request.NewTradingViewOrder
import com.kaya.trading.gateway.enum.BinanceAccount
import com.kaya.trading.gateway.enum.BinanceAccountEnum
import com.kaya.trading.gateway.enum.Exchange
import com.kaya.trading.gateway.remote.binance.request.NewBinanceOrderRequest
import com.kaya.trading.gateway.remote.binance.trade.BinanceTradeService
import org.springframework.stereotype.Service

@Service
class NewOrderService(private val binanceTradeService: BinanceTradeService) {

    fun createNewTestOrder(coinPair: String) {
        binanceTradeService.createNewTestOrder(coinPair)
    }

    fun createNewOrder(newTradingViewOrder: NewTradingViewOrder) {
        if (newTradingViewOrder.exchange == Exchange.BINANCE.name) {
            binanceTradeService.createNewOrder(
                NewBinanceOrderRequest(
                    newTradingViewOrder.ticker,
                    newTradingViewOrder.action,
                    newTradingViewOrder.contractCount,
                    BinanceAccount.getBinanceAccount(newTradingViewOrder.orderId)
                )
            )
        }
    }

    fun createNewPerpetualOrder(newTradingViewOrder: NewTradingViewOrder) {
        if (newTradingViewOrder.exchange == Exchange.BINANCE.name) {
            binanceTradeService.createNewPerpetualOrder(
                NewBinanceOrderRequest(
                    newTradingViewOrder.ticker,
                    newTradingViewOrder.action,
                    newTradingViewOrder.contractCount,
                    BinanceAccount.getBinanceAccount(newTradingViewOrder.orderId)
                )
            )
        }
    }

}