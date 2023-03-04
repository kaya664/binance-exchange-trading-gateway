package com.kaya.trading.gateway.enum

enum class BinanceAccountEnum(val apiSecretKey: String, val apiClientKey: String) {
    USER_FIRST("userFirstSecretKey", apiClientKey = "userFirstClientKey"),
    USER_SECOND("userSecondSecretKey", apiClientKey = "userSecondClientKey")
}

class BinanceAccount {
    companion object {
        fun getBinanceAccount(orderId: String): BinanceAccountEnum {
            return if(orderId == "userFirstOrderId"){
                BinanceAccountEnum.USER_FIRST
            } else if(orderId == "userSecondOrderId") {
                BinanceAccountEnum.USER_SECOND
            } else {
                throw Exception("Non supported order id")
            }
        }
    }
}
