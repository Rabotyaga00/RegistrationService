//package org.example.services
//
//import org.example.dto.UserResponse
//
//import org.springframework.context.annotation.Profile
//import org.springframework.stereotype.Service
//import java.util.*
//
//@Service
//@Profile("local") // Этот бин будет активен только для локального теста
//class MockUserClient : UserClient {
//
//    override fun getUserById(userId: UUID): UserResponse? {
//        return UserResponse(
//            id = userId,
//            email = "test@example.com",
//            password = "test",
//            isActive = true
//
//        )
//    }
//}
