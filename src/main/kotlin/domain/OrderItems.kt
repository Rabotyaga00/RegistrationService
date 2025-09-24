//package org.example.domain
//
//import jakarta.persistence.Column
//import jakarta.persistence.Id
//import java.math.BigDecimal
//import java.util.*
//
//data class OrderItems (
//    @Id
//    val id: UUID = UUID.randomUUID(),
//
//    @Column(nullable = false)
//    val order_id: UUID,
//    @Column(nullable = false)
//    val product_id: UUID,
//    @Column(nullable = false)
//    val quantity: BigDecimal,
//    @Column(nullable = false)
//    val price: BigDecimal
//)