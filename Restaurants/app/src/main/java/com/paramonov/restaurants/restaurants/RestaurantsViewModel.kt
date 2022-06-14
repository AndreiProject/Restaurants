package com.paramonov.restaurants.restaurants

import androidx.lifecycle.*
import com.paramonov.restaurants.common.controlflow.SingleLaunch
import com.paramonov.restaurants.common.extensions.flow.MutableSingleEventFlow
import com.paramonov.restaurants.restaurants.network.*
import com.paramonov.restaurants.restaurants.usecase.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.*
import javax.inject.Inject

class RestaurantsViewModel @Inject constructor(
    private val restaurantsGetter: RestaurantsGetter,
) : ViewModel() {
    private val _restaurants = MutableStateFlow(listOf<RestaurantsUiModel>())
    val restaurants = _restaurants.asStateFlow()

    private val _onError = MutableSingleEventFlow<String>()
    val onError = _onError.asSharedFlow()

    private val onlyLaunch = SingleLaunch()
    fun loadOnLaunch() = onlyLaunch {
        updateRestaurants()
    }

    fun updateRestaurants(search: String = "") {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = restaurantsGetter(search)) {
                is Result.Success -> _restaurants.value =
                    convertToRestaurantsUiModels(result.restaurants)
                is Result.Error -> _onError.tryEmit("Server is error")
            }
        }
    }

    private fun convertToRestaurantsUiModels(reviews: List<RestaurantsModel>) = reviews.map {
        RestaurantsUiModel(
            it.name,
            it.logo,
            "%d%s".format(it.positiveReviews, "%"),
            convertToLine(it.specializations)
        )
    }

    private fun convertToLine(specializations: List<Specialization>) = StringBuilder().apply {
        specializations.forEachIndexed() { index, item ->
            append(item.name)
            if (index < specializations.size - 1) append(" / ")
        }
    }.toString()
}