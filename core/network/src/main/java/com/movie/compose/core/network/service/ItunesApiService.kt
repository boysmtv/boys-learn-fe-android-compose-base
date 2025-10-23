package com.movie.compose.core.network.service

import com.movie.compose.core.model.response.NetworkMusicResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ItunesApiService {

    @Headers("Content-Type: application/json")
    @GET("search")
    fun getMusic(
        @Query("term") query: String?,
        @Query("entity") sort: String?
    ) : Single<NetworkMusicResponse>

}