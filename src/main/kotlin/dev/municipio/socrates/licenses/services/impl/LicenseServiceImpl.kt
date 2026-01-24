package dev.municipio.socrates.licenses.services.impl

import dev.municipio.socrates.licenses.models.License
import dev.municipio.socrates.licenses.models.dtos.LicenseDTO
import dev.municipio.socrates.licenses.repositories.LicenseRepository
import dev.municipio.socrates.licenses.services.LicenseService
import org.springframework.stereotype.Service

@Service
class LicenseServiceImpl(val licenseRepository: LicenseRepository) : LicenseService {

    override fun createLicense(license: LicenseDTO): License {
        val licenseEntity = License()
        licenseEntity.name = license.name
        licenseEntity.description = license.description
        licenseEntity.price = license.price

        return licenseRepository.save(licenseEntity)
    }

    override fun getAllLicenses(): List<License> {
        return licenseRepository.findAll()
    }

    override fun getLicenseById(id: Long): License {
        return licenseRepository.findById(id).orElse(License())
    }

    override fun deleteLicenseById(id: Long) {
        licenseRepository.deleteById(id)
    }
}