package org.example.dto

import java.util.*
data class SellerDTO (
    val id: UUID,
    val userId: UUID,
    val shopName: String,
    val createdAt: String
)
data class SellerResponseDTO(
//    val id: UUID,
    val userId: UUID,
    val shopName: String
)
data class UpdateSellerRequest(
    val userId: UUID,
    val shopName: String
)
