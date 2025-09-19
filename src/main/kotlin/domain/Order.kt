package org.example.domain


import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*


enum class OrderStatus { NEW, PAID, SHIPPED, CANCELED }


@Entity
@Table(name = "orders")
data class Order(
    @Id
    val id: UUID = UUID.randomUUID(),


    @Column(nullable = false)
    val buyerId: UUID,


    @Column(nullable = false)
    val sellerID: UUID,


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var status: OrderStatus = OrderStatus.NEW,


    @Column(nullable = false)
    val totalPrice: BigDecimal,


    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),


    @Column(nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()
)

