package com.movie.compose.data.movie.di

import com.movie.compose.data.movie.source.MovieRemoteDataSource
import com.movie.compose.data.movie.source.MovieRemoteDataSourceImpl
import com.movie.compose.data.movie.repository.MovieRepositoryImpl
import com.movie.compose.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MovieDataModule {

    @Binds
    @Singleton
    abstract fun bindMovieRemoteDataSource(
        impl: MovieRemoteDataSourceImpl
    ): MovieRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindMovieRepository(
        impl: MovieRepositoryImpl
    ): MovieRepository
}
