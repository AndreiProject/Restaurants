package com.paramonov.restaurants.restaurants.network.service

import com.paramonov.restaurants.common.network.Client

class ClientService(private val client: Client) {
    fun getService() : Service = client.getNet().create(Service::class.java)
}