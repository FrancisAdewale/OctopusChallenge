package com.example.octopuschallenge.network

import com.example.model.CatResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CatService {

    @GET("breeds")
    suspend fun getAllBreeds() : List<CatResponse>

    companion object{
        const val BASE_URL = "https://api.thecatapi.com/v1/"

        private var catService: CatService? = null

        fun getInstance() : CatService {
            if (catService == null) {
                catService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(CatService::class.java)
            }

            return catService!!
        }
    }

}