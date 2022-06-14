package com.paramonov.restaurants.hits.di

import androidx.lifecycle.ViewModel
import com.paramonov.restaurants.common.di.multibinding.map.ViewModelKey
import com.paramonov.restaurants.hits.HitsViewModel
import dagger.multibindings.IntoMap
import dagger.*

@Module
interface HitsViewModelModule {
    @Binds
    @[IntoMap ViewModelKey(HitsViewModel::class)]
    fun provideHitsViewModel(hitsViewModel: HitsViewModel): ViewModel
}