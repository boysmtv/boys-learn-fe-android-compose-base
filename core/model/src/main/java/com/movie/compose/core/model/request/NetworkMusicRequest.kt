package com.movie.compose.core.model.request

import com.squareup.moshi.Json

data class NetworkMusicRequest(
    @Json(name = "term") var term: String? = null,
    @Json(name = "entity") val entity: String = "song"
)