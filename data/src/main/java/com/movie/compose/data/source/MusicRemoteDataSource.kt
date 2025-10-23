package com.movie.compose.data.source

import com.movie.compose.core.model.request.NetworkMusicRequest
import com.movie.compose.core.model.response.NetworkMusicResponse
import io.reactivex.rxjava3.core.Single

interface MusicRemoteDataSource {

    fun getMusic(request: NetworkMusicRequest): Single<NetworkMusicResponse>

}
