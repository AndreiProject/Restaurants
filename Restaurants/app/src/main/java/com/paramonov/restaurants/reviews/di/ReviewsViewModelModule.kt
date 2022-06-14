package com.paramonov.restaurants.reviews.di

import androidx.lifecycle.ViewModel
import com.paramonov.restaurants.common.di.multibinding.map.ViewModelKey
import com.paramonov.restaurants.reviews.ReviewsViewModel
import dagger.multibindings.IntoMap
import dagger.*

@Module
interface ReviewsViewModelModule {
    @Binds
    @[IntoMap ViewModelKey(ReviewsViewModel::class)]
    fun provideReviewsViewModel(reviewsViewModel: ReviewsViewModel): ViewModel
}