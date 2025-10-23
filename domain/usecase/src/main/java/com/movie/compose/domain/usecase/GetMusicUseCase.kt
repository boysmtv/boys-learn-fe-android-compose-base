package com.movie.compose.domain.usecase

import com.movie.compose.core.model.request.NetworkMusicRequest
import com.movie.compose.domain.model.DomainMusic
import com.movie.compose.domain.repository.MusicRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMusicUseCase @Inject constructor(
    private val repository: MusicRepository
) {

    operator fun invoke(request: NetworkMusicRequest): Flow<List<DomainMusic>> {
        return repository.getMusic(request)
    }

}
