package com.example.retailer.service

import com.example.retailer.adapter.DistributorPublisher
import com.example.retailer.api.distributor.Order
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.core.Message
import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DistributorPublisherService : DistributorPublisher {
    @Autowired
    private lateinit var template: RabbitTemplate

    @Autowired
    private lateinit var topic: TopicExchange

    override fun placeOrder(order: Order): Boolean {
        val objectMapper = ObjectMapper()
        val message = objectMapper.writeValueAsString(order)
        if (order.id != null) {
            template.convertAndSend(
                topic.name,
                "distributor.placeOrder.lostlang.${order.id}",
                message
            ) { m: Message ->
                m.messageProperties.headers["Notify-Exchange"] = "distributor_exchange"
                m.messageProperties.headers["Notify-RoutingKey"] = "retailer.lostlang"
                m
            }
            return true
        }

        return false
    }
}