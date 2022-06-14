package com.paramonov.restaurants.restaurants.usecase

interface RestaurantsGetter {
    suspend operator fun invoke(search: String): Result
}