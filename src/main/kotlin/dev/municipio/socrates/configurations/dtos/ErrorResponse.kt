package dev.municipio.socrates.configurations.dtos

data class ErrorResponse(
    val success: Boolean,
    val message: String,
    val data: List<String>
)
