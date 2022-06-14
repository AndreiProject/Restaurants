package com.paramonov.restaurants.hits.usecase

class HitsGetterImpl(private val repository: HitsRepository) : HitsGetter {
    override suspend fun invoke() = repository.getHits()
}