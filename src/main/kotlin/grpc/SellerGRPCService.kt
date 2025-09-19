import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import net.devh.boot.grpc.server.service.GrpcService
import org.example.domain.OrderStatus
import org.example.proto.*
import org.example.services.SellerService

import java.math.BigDecimal
import java.util.*  

@GrpcService
class SellerGRPCService(
    private val sellerService: SellerService
) : SellerApiGrpcKt.SellerApiCoroutineImplBase() {

    override suspend fun createSeller(request: CreateSellerRequest): CreateSellerResponse = withContext(Dispatchers.IO) {
        val userId = UUID.fromString(request.userId)
        val seller = sellerService.registerSeller(userId, request.shopName)
        CreateSellerResponse.newBuilder()
            .setSellerId(seller.id.toString())
            .build()
    }

    override suspend fun createOrder(request: CreateOrderRequest): CreateOrderResponse = withContext(Dispatchers.IO) {
        val sellerId = UUID.fromString(request.sellerId)
        val buyerId = UUID.fromString(request.buyerId)
        val total = BigDecimal(request.totalPrice)
        val order = sellerService.createOrder(sellerId, buyerId, total)
        CreateOrderResponse.newBuilder()
            .setOrderId(order.id.toString())
            .build()
    }

    override suspend fun updateOrderStatus(request: UpdateOrderStatusRequest): UpdateOrderStatusResponse = withContext(Dispatchers.IO) {
        val sellerId = UUID.fromString(request.sellerId)
        val orderId = UUID.fromString(request.orderId)
        val status = OrderStatus.valueOf(request.status)
        val updated = sellerService.updateOrderStatus(sellerId, orderId, status)
        UpdateOrderStatusResponse.newBuilder()
            .setOrderId(updated.id.toString())
            .setStatus(updated.status.name)
            .build()
    }
}
