package dev.municipio.socrates.licenses.controllers

import dev.municipio.socrates.licenses.models.License
import dev.municipio.socrates.licenses.models.dtos.LicenseDTO
import dev.municipio.socrates.licenses.services.LicenseService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/api/v1/licenses")
class LicenseController(var licenseService: LicenseService) {

    @PostMapping
    fun createLicense(@Valid @RequestBody license: LicenseDTO): ResponseEntity<License> {

        val createdLicense = licenseService.createLicense(license)

        return ResponseEntity
            .created(URI.create("/api/v1/licenses/${createdLicense.id}"))
            .body(createdLicense)
    }

    @GetMapping
    fun getAllLicenses(): ResponseEntity<List<License>> {
        val licenses = licenseService.getAllLicenses()
        return ResponseEntity.ok(licenses)
    }

    @GetMapping("/{id}")
    fun getLicenseById(@PathVariable id: Long): ResponseEntity<License> {
        val license = licenseService.getLicenseById(id)
        if (license.id == null) return ResponseEntity.notFound().build()

        return ResponseEntity.ok(license)
    }

    @DeleteMapping("/{id}")
    fun deleteLicenseById(@PathVariable id: Long): ResponseEntity<Void> {
        licenseService.deleteLicenseById(id)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/{id}")
    fun updateLicense(@PathVariable id: Long, @Valid @RequestBody license: LicenseDTO): ResponseEntity<License> {
        val updatedLicense = licenseService.updateLicense(id, license)
        return ResponseEntity.ok(updatedLicense)
    }

}