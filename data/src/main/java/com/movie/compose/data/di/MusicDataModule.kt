package com.movie.compose.data.di

import com.movie.compose.data.repository.MusicRepositoryImpl
import com.movie.compose.data.source.MusicRemoteDataSource
import com.movie.compose.data.source.MusicRemoteDataSourceImpl
import com.movie.compose.domain.repository.MusicRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MusicDataModule {

    @Binds
    @Singleton
    abstract fun bindMusicRemoteDataSource(
        impl: MusicRemoteDataSourceImpl
    ): MusicRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindMusicRepository(
        impl: MusicRepositoryImpl
    ): MusicRepository

}
