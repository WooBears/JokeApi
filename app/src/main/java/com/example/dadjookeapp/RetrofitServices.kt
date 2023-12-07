package com.example.dadjookeapp

import com.example.dadjookeapp.model.JokeApi
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

//https://rapidapi.com/KegenGuyll/api/dad-jokes/?X-RapidAPI
object RetrofitServices {

    private val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://rapidapi.com")
        .addConverterFactory(GsonConverterFactory.create()).build()

    val api: JokeApi = retrofit.create(JokeApi::class.java)
}