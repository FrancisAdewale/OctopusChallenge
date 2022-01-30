package com.example.octopuschallenge.network

import com.example.model.CatResponse
import com.example.octopuschallenge.BASE_URL
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface CatService {

    @GET("breeds")
    suspend fun getAllBreeds(
        @Query("api_key") apiKey: String
    ) : List<CatResponse>

    @GET("breeds/search")
    suspend fun getBreedInfo(
        @Query("q") query: String)
    : CatResponse


    companion object{

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