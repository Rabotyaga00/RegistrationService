package org.example.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class UserResponse(
    val id: UUID,
    val email: String,
    val password: String,
    @JsonProperty("is_active")
    val isActive: Boolean
)
