package com.movie.compose.feature.movie.list.ui

import com.movie.compose.core.common.base.BaseUiState
import com.movie.compose.domain.model.DomainMovie

data class MovieListUiState(
    override val isLoading: Boolean = false,
    override val error: String? = null,
    val movies: List<DomainMovie> = emptyList()
) : BaseUiState