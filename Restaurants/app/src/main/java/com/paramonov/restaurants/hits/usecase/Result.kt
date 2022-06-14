package com.paramonov.restaurants.hits.usecase

import com.paramonov.restaurants.hits.network.HitsModel

sealed class Result {
    data class Success(val hits: List<HitsModel>) : Result()
    data class Error(val error: Throwable) : Result()
}