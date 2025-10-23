package com.movie.compose.data.mapper

import com.movie.compose.core.model.response.NetworkMusicResultResponse
import com.movie.compose.domain.model.DomainMusic

fun NetworkMusicResultResponse.toDomain() = DomainMusic(
    artistId = artistId,
    collectionId = collectionId,
    trackId = trackId,
    artistName = artistName,
    collectionName = collectionName,
    trackName = trackName,
    previewUrl = previewUrl,
    artworkUrl100 = artworkUrl100,
    isPlay = isPlay
)
