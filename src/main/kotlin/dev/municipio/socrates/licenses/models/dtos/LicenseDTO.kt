package dev.municipio.socrates.licenses.models.dtos

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.PositiveOrZero

data class LicenseDTO(
    @field:NotBlank("Name is a required field, please check!")
    val name: String?,

    @field:NotBlank("Description is a required field, please check!")
    val description: String?,

    @field:NotNull("Duration is a required field, please check!")
    val durationMoth: Int?,

    @field:NotNull("Price is a required field, please check!")
    @field:PositiveOrZero("Price must be positive or zero")
    val price: Double?,
)
