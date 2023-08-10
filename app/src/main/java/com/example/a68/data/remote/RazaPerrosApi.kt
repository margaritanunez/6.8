package com.example.a68.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RazaPerrosApi {

    @GET("breeds/list/all")
    suspend fun  getData(): Response<RazaPerros>

    @GET("breed/{id}/images")
    suspend fun getDetallePerro(@Path("id") id: String) : Response<RazaPerroDetalle>
}