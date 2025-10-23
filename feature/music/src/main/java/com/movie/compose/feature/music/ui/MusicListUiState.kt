package com.movie.compose.feature.music.ui

import com.movie.compose.core.common.base.BaseUiState
import com.movie.compose.domain.model.DomainMusic

data class MusicListUiState(
    override val isLoading: Boolean = false,
    override val error: String? = null,
    val musics: List<DomainMusic> = emptyList()
) : BaseUiState