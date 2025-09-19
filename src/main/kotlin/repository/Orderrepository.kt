package org.example.repository

import org.example.domain.Order
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface OrderRepository : JpaRepository<Order, UUID> {
    fun findAllBySellerId(sellerId: UUID): List<Order>
}