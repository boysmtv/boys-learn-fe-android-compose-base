package com.movie.compose.data.movie.mapper

import com.movie.compose.core.network.model.NetworkMovieItem
import com.movie.compose.domain.model.DomainMovie

fun NetworkMovieItem.toDomain(): DomainMovie =
    DomainMovie(
        id = id,
        title = title,
        overview = overview.orEmpty(),
        posterPath = "https://image.tmdb.org/t/p/w500${posterPath.orEmpty()}",
        releaseDate = releaseDate.orEmpty()
    )
