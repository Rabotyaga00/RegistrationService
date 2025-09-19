package org.example.dto

import org.example.domain.OrderStatus
import java.math.BigDecimal
import java.util.*

data class OrderRequestDTO(
    val sellerId: UUID,
    val buyerId: UUID,
    val totalPrice: BigDecimal
)

data class UpdateOrderStatusDTO(
    val orderId: UUID,
    val status: OrderStatus
)

data class OrderResponseDTO(
    val id: UUID,
    val sellerId: UUID,
    val buyerId: UUID,
    val status: OrderStatus,
    val totalPrice: BigDecimal,
    val createdAt: String,
    val updatedAt: String
)
