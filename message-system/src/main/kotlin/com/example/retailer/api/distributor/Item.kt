package com.example.retailer.api.distributor

import javax.persistence.*

/**
 * Описание товара
 */
@Entity
@Table(name = "items")
data class Item (
    /**
     * Произвольный идентификатор
     */
    @Id
    val id: Long? = null,

    /**
     * Произвольное название
     */
    val name: String
)