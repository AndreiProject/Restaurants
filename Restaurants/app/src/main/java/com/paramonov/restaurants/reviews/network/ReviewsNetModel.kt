package com.paramonov.restaurants.reviews.network

data class ReviewsNetModel(
    val isPositive: Boolean,
    val message: String,
    val dateAdded: String,
    val userFIO: String,
    val restaurantName: String
)