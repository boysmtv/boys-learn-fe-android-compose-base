package com.movie.compose.core.network.service

import com.movie.compose.core.network.model.NetworkMovieResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String
    ): Single<NetworkMovieResponse>

}
