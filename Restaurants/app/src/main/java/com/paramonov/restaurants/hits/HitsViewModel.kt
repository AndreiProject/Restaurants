package com.paramonov.restaurants.hits

import androidx.lifecycle.*
import com.paramonov.restaurants.common.controlflow.SingleLaunch
import com.paramonov.restaurants.common.extensions.flow.MutableSingleEventFlow
import com.paramonov.restaurants.hits.network.HitsModel
import com.paramonov.restaurants.hits.usecase.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.*
import javax.inject.Inject

class HitsViewModel @Inject constructor(private val hitsGetter: HitsGetter) : ViewModel() {
    private val _hits = MutableStateFlow(listOf<HitsModel>())
    val hits = _hits.asStateFlow()

    private val _onError = MutableSingleEventFlow<String>()
    val onError = _onError.asSharedFlow()

    private val onlyLaunch = SingleLaunch()
    fun loadOnLaunch() = onlyLaunch {
        updateHits()
    }

    private fun updateHits() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = hitsGetter()) {
                is Result.Success -> _hits.value = result.hits
                is Result.Error -> _onError.tryEmit("Server is error")
            }
        }
    }
}