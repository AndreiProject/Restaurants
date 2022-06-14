package com.paramonov.restaurants.hits.di

import com.paramonov.restaurants.common.network.Client
import com.paramonov.restaurants.hits.network.service.*
import com.paramonov.restaurants.hits.network.*
import com.paramonov.restaurants.hits.usecase.*
import dagger.*

@Module
class HitsModule {
    @Provides
    fun provideClientService(client: Client): ClientService = ClientService(client)

    @Provides
    fun provideService(clientService: ClientService): Service = clientService.getService()

    @Provides
    fun provideHitsRepository(service: Service): HitsRepository = HitsRepositoryImpl(service)

    @Provides
    fun provideHitsGetter(repository: HitsRepository): HitsGetter = HitsGetterImpl(repository)
}