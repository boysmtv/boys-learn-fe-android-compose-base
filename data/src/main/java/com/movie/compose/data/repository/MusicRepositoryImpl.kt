package com.movie.compose.data.repository

import com.movie.compose.core.model.request.NetworkMusicRequest
import com.movie.compose.data.mapper.toDomain
import com.movie.compose.data.source.MusicRemoteDataSource
import com.movie.compose.domain.model.DomainMusic
import com.movie.compose.domain.repository.MusicRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MusicRepositoryImpl @Inject constructor(
    private val musicRemoteDataSource: MusicRemoteDataSource
) : MusicRepository {

    override fun getMusic(request: NetworkMusicRequest): Flow<List<DomainMusic>> = flow {
        val response = musicRemoteDataSource.getMusic(request).blockingGet()
        response.results?.let { emit(it.map { it -> it.toDomain() }) }
    }

}
