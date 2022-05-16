package com.example.virgin_money_app.Model


import com.google.gson.annotations.SerializedName

data class PeopleItem(
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("email")
    val email: String,
    @SerializedName("favouriteColor")
    val favouriteColor: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("fromName")
    val fromName: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("jobtitle")
    val jobtitle: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("to")
    val to: String
)