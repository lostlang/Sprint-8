package com.example.retailer.adapter

interface RetailerConsumer {
    fun receiveOrder(orderInfo: String)
}