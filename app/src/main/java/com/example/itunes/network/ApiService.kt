package com.example.itunes.network

import com.example.itunes.data.ItunesResponseDto
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("search?term=Michael+jackson&amp;media=musicVideo")
    suspend fun fetchVideoList(): Response<ItunesResponseDto>
}