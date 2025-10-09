package com.movie.compose.data.movie.repository

import com.movie.compose.core.network.source.MovieNetworkDataSource
import com.movie.compose.data.movie.mapper.toDomain
import com.movie.compose.domain.model.DomainMovie
import com.movie.compose.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.rx3.asFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepositoryImpl @Inject constructor(
    private val networkDataSource: MovieNetworkDataSource
) : MovieRepository {

}
