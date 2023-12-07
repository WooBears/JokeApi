package com.example.dadjookeapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.dadjookeapp.model.JokeApi
import com.example.dadjookeapp.model.JokeModel
import retrofit2.Call
import retrofit2.Response

class Repository {

    private val api = RetrofitServices.api

    fun getData(key: String):MutableLiveData<JokeModel>{
        val joke = MutableLiveData<JokeModel>()

        api.getJokes(key = key).enqueue(object : retrofit2.Callback<JokeModel>{
            override fun onResponse(call: Call<JokeModel>, response: Response<JokeModel>) {
                if (response.isSuccessful){
                    response.body()?.let {
                        val jokeModel = JokeModel(it.href)
                        joke.value = jokeModel
                    }
                }
            }

            override fun onFailure(call: Call<JokeModel>, t: Throwable) {
                Log.e("ololo", "Failed: ${t.message}")
            }

        })

        return joke
    }
}