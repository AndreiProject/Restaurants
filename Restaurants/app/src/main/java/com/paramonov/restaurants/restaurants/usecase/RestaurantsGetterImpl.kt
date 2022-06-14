package com.paramonov.restaurants.restaurants.usecase

class RestaurantsGetterImpl(private val repository: RestaurantsRepository) : RestaurantsGetter {
    override suspend fun invoke(search: String) = repository.getRestaurants(search)
}