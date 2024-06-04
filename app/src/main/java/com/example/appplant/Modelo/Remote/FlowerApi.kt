package com.example.appplant.Modelo.Remote

import com.example.appplant.Modelo.Local.Entities.FlowerList
import com.example.appplant.Modelo.Remote.FromInternet.DetailsFlower
import com.example.appplant.Modelo.Remote.FromInternet.ListFlowers
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface FlowerApi {
    @GET("plantas")
    suspend fun  fetchFlowerList(): Response<List<ListFlowers>>



@GET("plantas/{id}")
suspend fun fetchFlowersDetail(@Path("id")id:Int): Response<DetailsFlower>










}