package com.paramonov.restaurants.restaurants.usecase

interface RestaurantsRepository {
    suspend fun getRestaurants(search: String): Result
}