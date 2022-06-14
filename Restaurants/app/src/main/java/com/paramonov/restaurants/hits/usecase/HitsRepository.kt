package com.paramonov.restaurants.hits.usecase

interface HitsRepository {
    suspend fun getHits(): Result
}