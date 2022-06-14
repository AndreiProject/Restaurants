package com.paramonov.restaurants.reviews.usecase

interface ReviewsGetter {
    suspend operator fun invoke(): Result
}