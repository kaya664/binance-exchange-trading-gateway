package com.kaya.trading.gateway.remote.binance.request

import com.kaya.trading.gateway.enum.BinanceAccountEnum
import java.math.BigDecimal

data class NewBinanceOrderRequest(
    val coinPair: String,
    var action: String,
    var contractCount: BigDecimal,
    var apiSecretKey: BinanceAccountEnum
)
