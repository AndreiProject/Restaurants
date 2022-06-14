package com.paramonov.restaurants.common.di

import com.paramonov.restaurants.common.di.multibinding.map.MultiViewModelFactory
import com.paramonov.restaurants.restaurants.di.*
import com.paramonov.restaurants.hits.di.*
import com.paramonov.restaurants.reviews.di.*
import javax.inject.Singleton
import dagger.Component

@Component(
    modules = [
        AppModule::class,
        RestaurantsModule::class,
        RestaurantsViewModelModule::class,
        HitsModule::class,
        HitsViewModelModule::class,
        ReviewsModule::class,
        ReviewsViewModelModule::class
    ]
)
@Singleton
interface AppComponent {
    val factory: MultiViewModelFactory
}