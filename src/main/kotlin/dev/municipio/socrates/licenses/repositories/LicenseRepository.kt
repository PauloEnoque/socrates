package dev.municipio.socrates.licenses.repositories

import dev.municipio.socrates.licenses.models.License
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LicenseRepository : JpaRepository<License, Long>
