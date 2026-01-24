package dev.municipio.socrates.licenses.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class License(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long
) {


}
