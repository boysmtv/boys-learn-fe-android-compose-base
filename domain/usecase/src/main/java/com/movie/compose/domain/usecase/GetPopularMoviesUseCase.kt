package com.movie.compose.domain.usecase

import com.movie.compose.domain.model.DomainMovie
import com.movie.compose.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(apiKey: String): Flow<List<DomainMovie>> {
        return repository.getPopularMovies(apiKey)
    }
}
