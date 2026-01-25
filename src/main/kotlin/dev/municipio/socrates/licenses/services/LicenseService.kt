package dev.municipio.socrates.licenses.services

import dev.municipio.socrates.licenses.models.License
import dev.municipio.socrates.licenses.models.dtos.LicenseDTO


interface LicenseService {
    fun createLicense(license: LicenseDTO): License
    fun getAllLicenses(): List<License>
    fun getLicenseById(id: Long): License
    fun deleteLicenseById(id: Long)
    fun updateLicense(id: Long, license: LicenseDTO): License
}
