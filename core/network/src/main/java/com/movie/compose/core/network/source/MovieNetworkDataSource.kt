package com.movie.compose.core.network.source

import com.movie.compose.core.network.model.NetworkMovieResponse
import com.movie.compose.core.network.service.MovieApiService
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieNetworkDataSource @Inject constructor(
    private val apiService: MovieApiService
) {
    fun getPopularMovies(apiKey: String, page: Int = 1): Single<NetworkMovieResponse> =
        apiService.getPopularMovies(apiKey, page)

    fun getPopularMoviesFlow(apiKey: String, page: Int = 1): Flow<NetworkMovieResponse> = flow {
        val response = apiService.getPopularMovies(apiKey, page).blockingGet()
        emit(response)
    }
}
