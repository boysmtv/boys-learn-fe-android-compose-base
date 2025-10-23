package com.movie.compose.data.source

import com.movie.compose.core.model.request.NetworkMusicRequest
import com.movie.compose.core.model.response.NetworkMusicResponse
import com.movie.compose.core.network.service.ItunesApiService
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class MusicRemoteDataSourceImpl @Inject constructor(
    private val service: ItunesApiService
) : MusicRemoteDataSource {

    override fun getMusic(request: NetworkMusicRequest): Single<NetworkMusicResponse> {
        return service.getMusic(request.term, request.entity)
    }
}
