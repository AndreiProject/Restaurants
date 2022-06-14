package com.paramonov.restaurants.hits.network.service

import com.paramonov.restaurants.hits.network.HitsModel
import retrofit2.Response
import retrofit2.http.*

interface Service {
    @GET
    suspend fun getHits(
        @Url requestUrl: String = "https://front-task.chibbistest.ru/api/v1/hits",
    ): Response<List<HitsModel>>
}