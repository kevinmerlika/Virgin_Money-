package com.example.virgin_money_app.Network

import com.example.virgin_money_app.Model.PeopleItem
import com.example.virgin_money_app.Model.RoomsItem
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("people")
    suspend fun getPeople(): Response<List<PeopleItem>>

    @GET("rooms")
    suspend fun getRooms(): Response<List<RoomsItem>>
}