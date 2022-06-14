package com.paramonov.restaurants.reviews.usecase

interface ReviewsRepository {
    suspend fun getReviews(): Result
}