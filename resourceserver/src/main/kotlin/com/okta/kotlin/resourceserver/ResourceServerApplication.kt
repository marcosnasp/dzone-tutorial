package com.okta.kotlin.resourceserver

import com.okta.kotlin.resourceserver.model.CoffeeShopModel
import com.okta.kotlin.resourceserver.repository.CoffeeShopRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class ResourceServerApplication {
    val logger: Logger = LoggerFactory.getLogger(javaClass)

    @Bean
    fun run(repository: CoffeeShopRepository) = ApplicationRunner {
        val coffee1: CoffeeShopModel =
                repository.save(CoffeeShopModel(
                        name = "Oblique",
                        address = "3039 SE Stark St, Portland, OR 97214",
                        phone = "555-111-4444",
                        priceOfCoffee = 1.50,
                        powerAccessible = true,
                        internetReliability = 5
                ))
        logger.info("Gravando a primeira cafeteria: ${coffee1.id}")
        val coffee2: CoffeeShopModel = repository.save(CoffeeShopModel(
                name = "Epoch Coffee",
                address = "221 W N Loop Blvd, Austin, TX 78751",
                phone = "555-111-2424",
                priceOfCoffee = 2.50,
                powerAccessible = true,
                internetReliability = 3
        ))
        logger.info("Gravando a segunda cafeteria: ${coffee2.id}")
    }
}

fun main(args: Array<String>) {
    runApplication<ResourceServerApplication>(*args)
}