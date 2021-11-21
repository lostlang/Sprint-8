package com.example.retailer.service

import com.example.retailer.adapter.RetailerConsumer
import com.example.retailer.api.distributor.OrderInfo
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RetailerConsumerService: RetailerConsumer {
    @Autowired
    lateinit var orderService: OrderService

    @RabbitListener(queues = ["retailer_queue"])
    override fun receiveOrder(orderInfo: String) {
        val mapper = ObjectMapper()
        val info = mapper.readValue(orderInfo, OrderInfo::class.java)
        orderService.updateOrderInfo(info)
    }
}