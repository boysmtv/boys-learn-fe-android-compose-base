package com.movie.compose.domain.repository

import com.movie.compose.core.model.request.NetworkMusicRequest
import com.movie.compose.domain.model.DomainMusic
import kotlinx.coroutines.flow.Flow

interface MusicRepository {

    fun getMusic(request: NetworkMusicRequest): Flow<List<DomainMusic>>

}