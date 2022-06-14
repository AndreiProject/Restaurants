package com.paramonov.restaurants.hits.network

import com.paramonov.restaurants.hits.network.service.Service
import com.paramonov.restaurants.hits.usecase.*
import java.lang.*

class HitsRepositoryImpl(private val service: Service) : HitsRepository {
    override suspend fun getHits(): Result {
        return try {
            val response = service.getHits()
            val body = response.body()

            if (body != null) Result.Success(body)
            else Result.Error(RuntimeException("Weather body is null"))
        } catch (ex: Exception) {
            Result.Error(ex)
        }
    }
}