//package org.example.DTO
//
//import org.example.domain.Order
//import org.example.domain.Seller
//import org.example.dto.OrderResponseDTO
//
//class Mappers {
//    fun Seller.toDTO() = SellerResponseDTO(
//        id = this.id,
//        userId = this.userId,
//        shopName = this.shopName,
//        createdAt = this.createdAt.toString()
//    )
//
//    fun Order.toDTO() = OrderResponseDTO(
//        id = this.id,
//        sellerId = this.sellerID,
//        buyerId = this.buyerId,
//        status = this.status,
//        totalPrice = this.totalPrice,
//        createdAt = this.createdAt.toString(),
//        updatedAt = this.updatedAt.toString()
//    )
//}