package com.paramonov.restaurants.restaurants.network

import com.paramonov.restaurants.common.extensions.lowerCase
import com.paramonov.restaurants.restaurants.network.service.*
import com.paramonov.restaurants.restaurants.usecase.*
import java.lang.*
import java.util.*

class RestaurantsRepositoryImpl(private val service: Service) : RestaurantsRepository {
    override suspend fun getRestaurants(search: String): Result {
        return try {
            val response = service.getRestaurants()
            val body = response.body()

            if (body != null) Result.Success(filter(search, body))
            else Result.Error(RuntimeException("Weather body is null"))
        } catch (ex: Exception) {
            Result.Error(ex)
        }
    }

    private fun filter(
        search: String,
        restaurants: List<RestaurantsModel>,
    ): List<RestaurantsModel> {
        if (search.isBlank()) return restaurants
        return restaurants.filter {
            it.name.lowerCase().startsWith(search.lowerCase())
        }
    }
}