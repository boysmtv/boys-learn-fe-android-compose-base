package com.movie.compose.core.network.model

import com.squareup.moshi.Json

data class NetworkMovieResponse(
    @Json(name = "page") val page: Int,
    @Json(name = "results") val results: List<NetworkMovieItem>,
    @Json(name = "total_pages") val totalPages: Int,
    @Json(name = "total_results") val totalResults: Int
)

data class NetworkMovieItem(
    @Json(name = "id") val id: Int,
    @Json(name = "title") val title: String,
    @Json(name = "overview") val overview: String?,
    @Json(name = "poster_path") val posterPath: String?,
    @Json(name = "release_date") val releaseDate: String?
)
