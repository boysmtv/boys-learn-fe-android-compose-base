package com.movie.compose.feature.music.ui

import com.movie.compose.core.common.base.BaseUiEvent


sealed class MusicListUiEvent : BaseUiEvent {
    data class ShowToast(val message: String) : MusicListUiEvent()
    data class NavigateToDetail(val movieId: Int) : MusicListUiEvent()
}