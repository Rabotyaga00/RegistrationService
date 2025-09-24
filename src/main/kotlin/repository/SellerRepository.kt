package org.example.repository

import org.example.domain.Seller
import org.springframework.data.jpa.repository.JpaRepository

import java.util.*

interface SellerRepository : JpaRepository<Seller, UUID> {
}