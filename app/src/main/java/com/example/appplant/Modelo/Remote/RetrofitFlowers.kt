package com.example.appplant.Modelo.Remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFlowers {

    companion object {
        private const val BASE_URL = "https://my-json-server.typicode.com/mauricioponce/TDApi/"

        lateinit var  getRetrofit : Retrofit

        fun getRetrofit(): FlowerApi {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(FlowerApi::class.java)


        }

    }

}