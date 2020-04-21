package com.okta.kotlin.resourceserver.repository

import com.okta.kotlin.resourceserver.model.CoffeeShopModel
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "coffeeshops", path = "coffeeshops")
interface CoffeeShopRepository : CrudRepository<CoffeeShopModel, Long> { }