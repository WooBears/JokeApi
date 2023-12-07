package com.example.dadjookeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.dadjookeapp.databinding.ActivityMainBinding
import com.example.dadjookeapp.model.JokeModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//https://rapidapi.com/KegenGuyll/api/dad-jokes/?X-RapidAPI-Key=3e594b6565msh8ef2a36fdf0108dp113257jsn441a90df4099&amp%3BX-RapidAPI-Host=dad-jokes.p.rapidapi.com

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val repository = Repository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnJoke.setOnClickListener {
                repository.getData(key = tvSetup.text.toString()).observe(this@MainActivity, Observer {
                    if (it != null){
                        repository.getData(it.href).observe(this@MainActivity, Observer {
                            // Handle the result of the second call here
                        })
                    }
                })
            }
        }
    }
}