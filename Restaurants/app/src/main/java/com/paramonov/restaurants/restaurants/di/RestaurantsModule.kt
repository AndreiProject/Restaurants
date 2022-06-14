package com.paramonov.restaurants.restaurants.di

import com.paramonov.restaurants.common.network.Client
import com.paramonov.restaurants.restaurants.network.service.*
import com.paramonov.restaurants.restaurants.network.*
import com.paramonov.restaurants.restaurants.usecase.*
import dagger.*

@Module
class RestaurantsModule {
    @Provides
    fun provideClientService(client: Client): ClientService = ClientService(client)

    @Provides
    fun provideService(clientService: ClientService): Service = clientService.getService()

    @Provides
    fun provideRestaurantsRepository(
        service: Service
    ): RestaurantsRepository = RestaurantsRepositoryImpl(service)

    @Provides
    fun provideRestaurantsGetter(
        repository: RestaurantsRepository
    ): RestaurantsGetter = RestaurantsGetterImpl(repository)
}