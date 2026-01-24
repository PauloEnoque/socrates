package dev.municipio.socrates.licenses.controllers

import dev.municipio.socrates.licenses.models.License
import dev.municipio.socrates.licenses.models.dtos.LicenseDTO
import dev.municipio.socrates.licenses.services.LicenseService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("/api/v1/licenses")
class LicenseController(var licenseService: LicenseService) {

    @PostMapping
    fun createLicense(@Valid @RequestBody license: LicenseDTO): ResponseEntity<License> {

        val createdLicense = licenseService.createLicense(license)

        return ResponseEntity
            .created(URI.create("/api/v1/licenses/${createdLicense.id}"))
            .build()
    }
}