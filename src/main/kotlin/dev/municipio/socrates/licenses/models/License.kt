package dev.municipio.socrates.licenses.models

import jakarta.persistence.*
import lombok.Data

@Data
@Entity
class License {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "License_id")
    var id: Long? = null

    @Column(name = "name")
    var name: String? = null

    @Column(name = "description")
    var description: String? = null

    @Column(name = "price")
    var price: Double? = null
}
