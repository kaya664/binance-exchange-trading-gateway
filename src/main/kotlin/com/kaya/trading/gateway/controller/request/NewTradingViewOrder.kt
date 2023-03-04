package com.kaya.trading.gateway.controller.request

import java.math.BigDecimal

data class NewTradingViewOrder(
    val exchange: String,
    val ticker: String,
    var closePrice: BigDecimal,
    var volume: BigDecimal,
    var action: String,
    var contractCount: BigDecimal,
    var orderId: String = "",
    var coinType: String = "NORMAL"
)