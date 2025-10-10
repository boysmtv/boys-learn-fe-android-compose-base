package com.movie.compose.data.movie.source

import com.movie.compose.core.network.model.NetworkMovieResponse
import com.movie.compose.core.network.service.MovieApiService
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(
    private val service: MovieApiService
) : MovieRemoteDataSource {

    override fun getPopularMovies(): Single<NetworkMovieResponse> {
        return service.getPopularMovies()
    }
}
