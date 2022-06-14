package com.paramonov.restaurants.reviews.di

import com.paramonov.restaurants.common.network.Client
import com.paramonov.restaurants.reviews.network.ReviewsRepositoryImpl
import com.paramonov.restaurants.reviews.network.service.*
import com.paramonov.restaurants.reviews.usecase.*
import dagger.*

@Module
class ReviewsModule {
    @Provides
    fun provideClientService(client: Client): ClientService = ClientService(client)

    @Provides
    fun provideService(clientService: ClientService): Service = clientService.getService()

    @Provides
    fun provideReviewsRepository(
        service: Service,
    ): ReviewsRepository = ReviewsRepositoryImpl(service)

    @Provides
    fun provideReviewsGetter(
        repository: ReviewsRepository,
    ): ReviewsGetter = ReviewsGetterImpl(repository)
}