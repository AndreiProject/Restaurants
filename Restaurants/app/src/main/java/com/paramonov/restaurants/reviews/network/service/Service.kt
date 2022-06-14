package com.paramonov.restaurants.reviews.network.service

import com.paramonov.restaurants.reviews.network.ReviewsNetModel
import retrofit2.Response
import retrofit2.http.*

interface Service {
    @GET
    suspend fun getReviews(
        @Url requestUrl: String = "https://front-task.chibbistest.ru/api/v1/reviews",
    ): Response<List<ReviewsNetModel>>
}