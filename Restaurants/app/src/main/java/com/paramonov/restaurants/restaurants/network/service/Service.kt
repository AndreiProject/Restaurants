package com.paramonov.restaurants.restaurants.network.service

import com.paramonov.restaurants.restaurants.network.RestaurantsModel
import retrofit2.Response
import retrofit2.http.*

interface Service {
    @GET
    suspend fun getRestaurants(
        @Url requestUrl: String = "https://front-task.chibbistest.ru/api/v1/restaurants",
    ): Response<List<RestaurantsModel>>
}