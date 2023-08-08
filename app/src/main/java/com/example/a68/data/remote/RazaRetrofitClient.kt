package com.example.a68.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RazaRetrofitClient {

    companion object {
        private const val URL_BASE = "https://dog.ceo/api/"

        fun getRetrofitRaza(): RazaPerrosApi {

            val mRetrofit = Retrofit.Builder().baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create()).build()
            return mRetrofit.create(RazaPerrosApi::class.java)
        }
    }
}