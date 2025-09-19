package org.example.services
import UserResponse
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import java.util.*

@Service
class UserClient {
    private val webClient = WebClient.create("http://go-service:8080/api")

    fun getUserById(userId: UUID): UserResponse? {
        return try {
            webClient.get()
                .uri("/users/{id}", userId)
                .retrieve()
                .onStatus({ status -> status.is4xxClientError }) { Mono.empty() }
                .bodyToMono(UserResponse::class.java)
                .block()
        } catch (ex: Exception) {
            null
        }
    }

}
