package com.movie.compose.core.model.response

import com.squareup.moshi.Json

data class NetworkMusicResponse(
    @Json(name = "resultCount") val resultCount: Int? = null,
    @Json(name = "results") val results: List<NetworkMusicResultResponse>? = null
)

