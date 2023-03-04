package com.kaya.trading.gateway.service.wallet

import com.kaya.trading.gateway.remote.binance.BinanceSystemService
import com.kaya.trading.gateway.remote.binance.BinanceWalletService
import org.springframework.stereotype.Service

@Service
class WalletService(private var binanceWalletService: BinanceWalletService) {

    fun getCoinInformationForUser() {
        binanceWalletService.getAllCoinInformationsForUser()
    }

}