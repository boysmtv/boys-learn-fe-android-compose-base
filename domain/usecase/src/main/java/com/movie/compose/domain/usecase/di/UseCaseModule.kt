package com.movie.compose.domain.usecase.di

import com.movie.compose.domain.repository.MovieRepository
import com.movie.compose.domain.usecase.GetPopularMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetPopularMoviesUseCase(
        repository: MovieRepository
    ): GetPopularMoviesUseCase = GetPopularMoviesUseCase(repository)
}
