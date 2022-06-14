package com.paramonov.restaurants.restaurants.usecase

import com.paramonov.restaurants.restaurants.network.RestaurantsModel

sealed class Result {
    data class Success(val restaurants: List<RestaurantsModel>) : Result()
    data class Error(val error: Throwable) : Result()
}