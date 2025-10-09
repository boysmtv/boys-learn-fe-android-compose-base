package com.movie.compose.domain.usecase.movie

import com.movie.compose.domain.model.DomainMovie
import com.movie.compose.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
//    fun executeFlow(apiKey: String): Flow<List<DomainMovie>> {
//        return repository.getPopularMovies(apiKey)
//    }
}
