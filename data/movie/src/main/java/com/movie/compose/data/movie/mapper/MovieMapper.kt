package com.movie.compose.data.movie.mapper

import com.movie.compose.core.network.model.NetworkMovieItem
import com.movie.compose.domain.model.DomainMovie

fun NetworkMovieItem.toDomain() = DomainMovie(
    id = id,
    title = title,
    overview = overview,
    posterPath = posterPath,
    releaseDate = releaseDate
)
