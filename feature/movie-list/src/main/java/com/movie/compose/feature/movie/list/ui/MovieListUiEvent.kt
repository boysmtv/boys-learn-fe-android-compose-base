package com.movie.compose.feature.movie.list.ui

import com.movie.compose.core.common.base.BaseUiEvent


sealed class MovieListUiEvent : BaseUiEvent {
    data class ShowToast(val message: String) : MovieListUiEvent()
    data class NavigateToDetail(val movieId: Int) : MovieListUiEvent()
}