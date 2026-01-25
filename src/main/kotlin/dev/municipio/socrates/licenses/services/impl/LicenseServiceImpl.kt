package dev.municipio.socrates.licenses.services.impl

import dev.municipio.socrates.licenses.models.License
import dev.municipio.socrates.licenses.models.dtos.LicenseDTO
import dev.municipio.socrates.licenses.repositories.LicenseRepository
import dev.municipio.socrates.licenses.services.LicenseService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class LicenseServiceImpl(val licenseRepository: LicenseRepository) : LicenseService {

    val logger = LoggerFactory.getLogger(LicenseServiceImpl::class.java)

    override fun createLicense(license: LicenseDTO): License {
        logger.info("Creating license with name: ${license.name}")
        val licenseEntity = License()
        licenseEntity.name = license.name
        licenseEntity.description = license.description
        licenseEntity.price = license.price

        return licenseRepository.save(licenseEntity)
    }

    override fun getAllLicenses(): List<License> {
        logger.info("Getting all licenses")
        return licenseRepository.findAll()
    }

    override fun getLicenseById(id: Long): License {
        logger.info("Getting license with ID $id")
        return licenseRepository.findById(id).orElse(License())
    }

    override fun deleteLicenseById(id: Long) {
        logger.info("Deleting license with ID $id")
        licenseRepository.deleteById(id)
    }

    override fun updateLicense(
        id: Long,
        license: LicenseDTO
    ): License {
        logger.info("Updating license with ID $id")
        val existingLicense = licenseRepository.findById(id).orElse(null)
        if (existingLicense == null) {
            logger.error("License with ID $id not found")
        }

        existingLicense.name = license.name ?: existingLicense.name
        existingLicense.description = license.description ?: existingLicense.description
        existingLicense.price = license.price ?: existingLicense.price

        return licenseRepository.save(existingLicense)
    }
}