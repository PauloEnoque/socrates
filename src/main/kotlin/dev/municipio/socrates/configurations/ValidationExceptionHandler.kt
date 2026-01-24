package dev.municipio.socrates.configurations

import dev.municipio.socrates.configurations.dtos.ErrorResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidation(
        ex: MethodArgumentNotValidException
    ): ResponseEntity<ErrorResponse> {
        val messages = ex.bindingResult.fieldErrors
            .map { it.defaultMessage ?: "Invalid field: ${it.field}" }

        val error = ErrorResponse(
            success = false,
            message = "Validation Error",
            data = messages
        )

        return ResponseEntity.badRequest().body(error)
    }
}