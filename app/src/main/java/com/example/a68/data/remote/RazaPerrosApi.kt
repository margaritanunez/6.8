package com.example.a68.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface RazaPerrosApi {

    @GET("breeds/list/all")
    suspend fun  getData(): Response<RazaPerros>
}