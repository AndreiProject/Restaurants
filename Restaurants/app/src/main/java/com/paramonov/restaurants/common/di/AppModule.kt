package com.paramonov.restaurants.common.di

import com.paramonov.restaurants.common.network.Client
import dagger.*

@Module
class AppModule {
    @Provides
    fun provideClient(): Client = Client
}