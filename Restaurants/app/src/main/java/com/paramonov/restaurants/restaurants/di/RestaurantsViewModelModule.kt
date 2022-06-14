package com.paramonov.restaurants.restaurants.di

import androidx.lifecycle.ViewModel
import com.paramonov.restaurants.common.di.multibinding.map.ViewModelKey
import com.paramonov.restaurants.hits.HitsViewModel
import com.paramonov.restaurants.restaurants.RestaurantsViewModel
import dagger.multibindings.IntoMap
import dagger.*

@Module
interface RestaurantsViewModelModule {
    @Binds
    @[IntoMap ViewModelKey(RestaurantsViewModel::class)]
    fun provideRestaurantsViewModel(restaurantsViewModel: RestaurantsViewModel): ViewModel
}