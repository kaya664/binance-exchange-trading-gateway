package com.kaya.trading.gateway.service

import com.kaya.trading.gateway.service.marketdata.MarketDataService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MarketDataServiceIT {

    @Autowired
    private lateinit var marketDataService: MarketDataService

    @Test
    fun test() {
        //marketDataService.getMarketData("BNBBTC")
    }

}