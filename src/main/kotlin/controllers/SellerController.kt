package org.example.controllers

import org.example.dto.SellerDTO
import org.example.dto.SellerResponseDTO
import org.example.dto.UpdateSellerRequest
import org.example.domain.Seller
import org.example.repository.SellerRepository
import org.example.services.SellerService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/seller")
class SellerController (
    private val sellerService : SellerService
){
    @PostMapping
    fun createSeller(userId: UUID, name: String): SellerResponseDTO {
        val saved = sellerService.registerSeller(userId, name)
        return SellerResponseDTO(saved.userId,saved.shopName)
    }
    @GetMapping("/{id}")
    fun getSellerById(@PathVariable id: UUID): List<Seller> {
        return sellerService.listSellers(id)
    }
    @DeleteMapping("/{id}")
    fun deleteSellerById(@PathVariable id: UUID){
        sellerService.deleteSellerById(id)
    }
    @PatchMapping("/{id}")
    fun updateSellerById(
        @PathVariable id: UUID,
        @RequestBody request: UpdateSellerRequest
    ): SellerDTO {
        val saved = sellerService.sendSeller(request.userId, request.name)
        return SellerDTO(
            id = saved.id,
            userId = saved.userId,
            shopName = saved.shopName,
            createdAt = saved.createdAt.toString()
        )
    }

}

