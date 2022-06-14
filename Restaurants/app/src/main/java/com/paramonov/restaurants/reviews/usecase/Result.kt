package com.paramonov.restaurants.reviews.usecase

sealed class Result {
    data class Success(val reviews: List<ReviewsModel>) : Result()
    data class Error(val error: Throwable) : Result()
}