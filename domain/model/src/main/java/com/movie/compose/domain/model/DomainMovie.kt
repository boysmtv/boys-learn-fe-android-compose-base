package com.movie.compose.domain.model

data class DomainMovie(
    val id: Int,
    val title: String,
    val overview: String?,
    val posterPath: String?,
    val releaseDate: String?
)
