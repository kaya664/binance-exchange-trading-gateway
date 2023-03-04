package com.kaya.trading.gateway.service

import com.kaya.trading.gateway.service.trade.QueryOrderService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class QueryOrderServiceIT() {

    @Autowired
    private lateinit var queryOrderService: QueryOrderService

    @Test
    fun test() {
        //queryOrderService.getOrdersForSymbol("XECUSDT")
    }

}