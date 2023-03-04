package com.kaya.trading.gateway.service

import com.kaya.trading.gateway.service.wallet.WalletService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WalletServiceIT {

    @Autowired
    private lateinit var walletService: WalletService

    @Test
    fun when_GetWalletStatus() {
        //walletService.getCoinInformationForUser()
    }
}