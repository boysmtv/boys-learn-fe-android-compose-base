package com.movie.compose.core.network.service

import com.movie.compose.core.network.model.NetworkMovieResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET("movie")
    fun getMovie(
        @Query("page") page: Int? = null,
        @Query("language") language: String? = null,
        @Query("region") apiKey: String? = null
    ): Single<NetworkMovieResponse>

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("page") page: Int? = null,
        @Query("language") language: String? = null,
        @Query("region") apiKey: String? = null
    ): Single<NetworkMovieResponse>

    @GET("movie/top_rated")
    fun getTopRated(
        @Query("page") page: Int? = null,
        @Query("language") language: String? = null,
        @Query("region") apiKey: String? = null
    ): Single<NetworkMovieResponse>

    @GET("movie/upcoming")
    fun getUpcoming(
        @Query("page") page: Int? = null,
        @Query("language") language: String? = null,
        @Query("region") apiKey: String? = null
    ): Single<NetworkMovieResponse>

    @GET("movie/now_playing")
    fun getNowPlaying(
        @Query("page") page: Int? = null,
        @Query("language") language: String? = null,
        @Query("region") apiKey: String? = null
    ): Single<NetworkMovieResponse>

    @GET("search/movie")
    fun getSearchMovie(
        @Query("page") page: Int? = null,
        @Query("language") language: String? = null,
        @Query("region") apiKey: String? = null
    ): Single<NetworkMovieResponse>

}

