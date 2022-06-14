package com.paramonov.restaurants.hits.usecase

interface HitsGetter {
    suspend operator fun invoke(): Result
}