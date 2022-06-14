package com.paramonov.restaurants.reviews

import androidx.lifecycle.*
import com.paramonov.restaurants.common.controlflow.SingleLaunch
import com.paramonov.restaurants.common.extensions.flow.MutableSingleEventFlow
import com.paramonov.restaurants.common.extensions.formatToString
import com.paramonov.restaurants.reviews.usecase.Result
import com.paramonov.restaurants.reviews.usecase.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.*
import javax.inject.Inject

const val DAY_TIME_PATTERN = "dd.MM.yyyy HH:mm"

class ReviewsViewModel @Inject constructor(private val reviewsGetter: ReviewsGetter) : ViewModel() {
    private val _reviews = MutableStateFlow(listOf<ReviewsUiModel>())
    val reviews = _reviews.asStateFlow()

    private val _onError = MutableSingleEventFlow<String>()
    val onError = _onError.asSharedFlow()

    private val onlyLaunch = SingleLaunch()
    fun loadOnLaunch() = onlyLaunch {
        updateReviews()
    }

    private fun updateReviews() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = reviewsGetter()) {
                is Result.Success -> _reviews.value = convertToReviewsUiModels(result.reviews)
                is Result.Error -> _onError.tryEmit("Server is error")
            }
        }
    }

    private fun convertToReviewsUiModels(reviews: List<ReviewsModel>) = reviews.map {
        ReviewsUiModel(
            it.isPositive,
            "%s о ресторане: %s".format(it.userFIO, it.restaurantName),
            it.message,
            it.dateAdded.formatToString(DAY_TIME_PATTERN)
        )
    }
}