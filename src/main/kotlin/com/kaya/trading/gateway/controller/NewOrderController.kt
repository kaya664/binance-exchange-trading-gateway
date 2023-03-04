package com.kaya.trading.gateway.controller

import com.kaya.trading.gateway.controller.request.NewTradingViewOrder
import com.kaya.trading.gateway.enum.CoinType
import com.kaya.trading.gateway.service.trade.NewOrderService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class NewOrderController(private val newOrderService: NewOrderService) {

    @PostMapping("/new")
    fun newOrder(@RequestBody request: NewTradingViewOrder): HttpStatus {
        println(request.action + " " + request.ticker + " " + request.exchange + " " + request.orderId)
        if(request.orderId == "userFirstOrderId" || request.orderId == "userSecondOrderId") {
            if(request.coinType == CoinType.NORMAL.name) {
                newOrderService.createNewOrder(request)
            } else if(request.coinType == CoinType.PERPETUAL.name) {
                newOrderService.createNewPerpetualOrder(request)
            }
        } else {
            println("Wrong order id ${request.orderId}")
        }
        return HttpStatus.OK
    }

}