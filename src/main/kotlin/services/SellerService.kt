package org.example.services


//import org.example.domain.Order
//import org.example.domain.OrderStatus
//import org.example.repository.OrderRepository
import jakarta.transaction.Transactional
import org.example.domain.Seller
import org.example.repository.SellerRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class SellerService(
    private val sellerRepository: SellerRepository,
  //  private val orderRepository: OrderRepository,
    private val userClient: UserClient
) {
    fun sendSeller(userId: UUID, shopName: String): Seller {
        val seller = Seller(
            userId = userId,
            shopName = shopName,
        )
        return sellerRepository.save(seller)
    }

    @Transactional
    fun registerSeller(id: UUID, name: String): Seller {
        val existing = sellerRepository.findById(id)
        if (existing.isPresent) {
            throw IllegalArgumentException("Seller already exists")
        }
        val existingUser = userClient.getUserById(id)
        if (existingUser == null) {
            throw IllegalArgumentException("User $id not found")
        }
        return sellerRepository.save(Seller(userId = id, shopName = name))
    }
    fun listSellers(id: UUID): List<Seller>{
        return sellerRepository.findAll()
    }
    fun deleteSellerById(id : UUID){
        if(sellerRepository.existsById(id)){
            sellerRepository.deleteById(id)
        }else{
            throw RuntimeException("Seller with id $id not found")
        }
    }
//    @Transactional
//    fun createOrder(sellerId: UUID, buyerId: UUID, totalPrice: BigDecimal): Order {
//        if (!sellerRepository.existsById(sellerId)) throw IllegalArgumentException("Seller not found")
//        val order = Order(
//            sellerID = sellerId,
//            buyerId = buyerId,
//            status = OrderStatus.NEW,
//            totalPrice = totalPrice
//        )
//        return orderRepository.save(order)
//    }
//    @Transactional
//    fun updateOrderStatus(sellerId: UUID, orderId: UUID, status: OrderStatus): Order {
//        val order = orderRepository.findById(orderId).orElseThrow { IllegalArgumentException("Order not found") }
//        if (order.sellerID != sellerId) throw IllegalAccessException("Not allowed")
//        order.status = status
//        order.updatedAt = LocalDateTime.now()
//        return orderRepository.save(order)
//    }
}
