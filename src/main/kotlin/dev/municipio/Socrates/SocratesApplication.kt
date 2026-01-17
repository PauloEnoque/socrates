package dev.municipio.Socrates

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SocratesApplication

fun main(args: Array<String>) {
	runApplication<SocratesApplication>(*args)
}
