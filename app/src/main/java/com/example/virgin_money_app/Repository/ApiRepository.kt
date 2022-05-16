package com.example.virgin_money_app.Repository

import com.example.virgin_money_app.Network.Api
import javax.inject.Inject

class ApiRepository
@Inject
constructor(private val api: Api)  {
    suspend fun getAllPeople() = api.getPeople()
}