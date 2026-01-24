package dev.municipio.socrates.licenses.services

import dev.municipio.socrates.licenses.models.License
import dev.municipio.socrates.licenses.models.dtos.LicenseDTO
import org.springframework.stereotype.Service

@Service
interface LicenseService {
    fun createLicense(license: LicenseDTO): License
}
