package com.paramonov.restaurants.reviews.usecase

class ReviewsGetterImpl(private val repository: ReviewsRepository) : ReviewsGetter {
    override suspend fun invoke() = repository.getReviews()
}