package com.paramonov.restaurants.reviews.usecase

import java.util.*

data class ReviewsModel(
    val isPositive: Boolean,
    val message: String,
    val dateAdded: Date,
    val userFIO: String,
    val restaurantName: String,
)