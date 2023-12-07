package com.example.dadjookeapp.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

//https://rapidapi.com/KegenGuyll/api/dad-jokes/?X-RapidAPI-Key
interface JokeApi {
    @GET("KegenGuyll/api/dad-jokes/")
    fun getJokes(
        @Header("X-RapidAPI-Key") key: String = "3e594b6565msh8ef2a36fdf0108dp113257jsn441a90df4099",
    ): Call<JokeModel>
}