package com.paramonov.restaurants.reviews.network

import com.paramonov.restaurants.common.extensions.isoDateTimeConvertToDate
import com.paramonov.restaurants.reviews.usecase.Result
import com.paramonov.restaurants.reviews.network.service.Service
import com.paramonov.restaurants.reviews.usecase.ReviewsModel
import com.paramonov.restaurants.reviews.usecase.ReviewsRepository
import java.lang.*

class ReviewsRepositoryImpl(private val service: Service) : ReviewsRepository {
    override suspend fun getReviews(): Result {
        return try {
            val response = service.getReviews()
            val body = response.body()

            if (body != null) Result.Success(convertToReviewsModels(body))
            else Result.Error(RuntimeException("Weather body is null"))
        } catch (ex: Exception) {
            Result.Error(ex)
        }
    }

    private fun convertToReviewsModels(reviews: List<ReviewsNetModel>) = reviews.map {
        ReviewsModel(
            it.isPositive,
            it.message.trim(),
            it.dateAdded.isoDateTimeConvertToDate(),
            it.userFIO,
            it.restaurantName
        )
    }
}