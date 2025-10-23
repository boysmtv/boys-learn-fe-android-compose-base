package com.movie.compose.core.model.response

import com.squareup.moshi.Json

data class NetworkMusicResultResponse(
    @Json(name = "artistId") val artistId: Long? = null,
    @Json(name = "collectionId") val collectionId: Long? = null,
    @Json(name = "trackId") val trackId: Long? = null,
    @Json(name = "artistName") val artistName: String? = null,
    @Json(name = "collectionName") val collectionName: String? = null,
    @Json(name = "trackName") val trackName: String? = null,
    @Json(name = "previewUrl") val previewUrl: String? = null,
    @Json(name = "artworkUrl100") val artworkUrl100: String? = null,
    @Json(name = "isPlay") val isPlay: Boolean = false
)