package com.movie.compose.data.movie.repository

import com.movie.compose.data.movie.source.MovieRemoteDataSource
import com.movie.compose.data.movie.mapper.toDomain
import com.movie.compose.domain.model.DomainMovie
import com.movie.compose.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val remoteDataSource: MovieRemoteDataSource
) : MovieRepository {

    override fun getPopularMovies(apiKey: String): Flow<List<DomainMovie>> = flow {
        val response = remoteDataSource.getPopularMovies(apiKey).blockingGet()
        emit(response.results.map { it.toDomain() })
    }

}
