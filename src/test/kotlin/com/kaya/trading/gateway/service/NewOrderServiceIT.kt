package com.kaya.trading.gateway.service

import com.kaya.trading.gateway.service.trade.NewOrderService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class NewOrderServiceIT {

    @Autowired
    private lateinit var newOrderService: NewOrderService

    @Test
    fun test() {
            when (""?.let { Regex("^\$|[\\w-]+\$").matches(it) }) {
                true -> print(true)
                false -> print(false)
            }
        //newOrderService.createNewTestOrder("XECUSDT")
    }

}