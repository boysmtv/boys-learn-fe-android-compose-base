package com.movie.compose.feature.movie.list.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movie.compose.domain.usecase.GetPopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(MovieListUiState())
    val uiState: StateFlow<MovieListUiState> = _uiState

    fun loadMovies(apiKey: String) {
        viewModelScope.launch {
            getPopularMoviesUseCase(apiKey)
                .onStart { _uiState.value = _uiState.value.copy(isLoading = true, error = null) }
                .catch { e -> _uiState.value = _uiState.value.copy(isLoading = false, error = e.message) }
                .collect { movies ->
                    _uiState.value = _uiState.value.copy(isLoading = false, movies = movies)
                }
        }
    }
}