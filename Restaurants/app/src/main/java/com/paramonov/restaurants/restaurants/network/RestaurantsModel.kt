package com.paramonov.restaurants.restaurants.network

data class RestaurantsModel (
    val name: String,
    val logo: String,
    val positiveReviews: Int,
    val specializations: List<Specialization>
)

data class Specialization (
    val name: String
)