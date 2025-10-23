package com.movie.compose.domain.model

data class DomainMusic(
    val artistId: Long?,
    val collectionId: Long?,
    val trackId: Long?,
    val artistName: String?,
    val collectionName: String?,
    val trackName: String?,
    val previewUrl: String?,
    val artworkUrl100: String?,
    val isPlay: Boolean
)
