package com.example.countriesandflags_hw.network

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL =
    "https://countriesnow.space/api/v0.1/countries/flag"


  private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactor)
    .build()

 private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface CountriesApiService {

    @GET("images")
    suspend fun getPhotos(): List<Countries>
}

object FlagApi {
    val retrofitService : CountriesApiService by lazy {
        retrofit.create(CountriesApiService::class.java) }
}


