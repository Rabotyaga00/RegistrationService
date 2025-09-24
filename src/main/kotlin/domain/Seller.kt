package org.example.domain


import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*
@Entity
@Table(name = "sellers")
data class Seller(
    @Id
    val id: UUID = UUID.randomUUID(),

    @Column(nullable = false, unique = true)
    val userId: UUID,

    @Column(nullable = false)
    val shopName: String,

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()
)