package com.movie.compose.data.movie.source

import com.movie.compose.core.network.model.NetworkMovieResponse
import io.reactivex.rxjava3.core.Single

interface MovieRemoteDataSource {

    fun getPopularMovies(): Single<NetworkMovieResponse>

}
