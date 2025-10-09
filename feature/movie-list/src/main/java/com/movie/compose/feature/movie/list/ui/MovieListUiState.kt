package com.movie.compose.feature.movie.list.ui

import com.movie.compose.domain.model.DomainMovie

data class MovieListUiState(
    val isLoading: Boolean = false,
    val movies: List<DomainMovie> = emptyList(),
    val error: String? = null
)
