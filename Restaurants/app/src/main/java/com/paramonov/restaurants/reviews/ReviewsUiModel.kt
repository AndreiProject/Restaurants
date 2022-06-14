package com.paramonov.restaurants.reviews

data class ReviewsUiModel(
    val isPositive: Boolean,
    val title: String,
    val message: String,
    val data: String,
)