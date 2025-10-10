package com.movie.compose.feature.movie.list.ui

import android.util.Log
import com.movie.compose.core.common.base.BaseViewModel
import com.movie.compose.domain.model.DomainMovie
import com.movie.compose.domain.usecase.GetPopularMoviesUseCase
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
) : BaseViewModel<MovieListUiState, MovieListUiEvent>(MovieListUiState()) {

    fun loadMovies() {
        launchIO {
            getPopularMoviesUseCase()
                .onStart { updateUi { copy(isLoading = true, error = null) } }
                .catch { e ->
                    updateUi { copy(isLoading = false, error = e.message) }
                    sendEvent(MovieListUiEvent.ShowToast("Failed: ${e.message}"))
                }
                .collect { movies ->
                    val moshi = Moshi.Builder()
                        .add(KotlinJsonAdapterFactory())
                        .build()
                    val type = Types.newParameterizedType(List::class.java, DomainMovie::class.java)
                    val adapter = moshi.adapter<List<DomainMovie>>(type)
                    logLongJson("MyResponse", adapter.toJson(movies))
                    updateUi { copy(isLoading = false, movies = movies) }
                }
        }
    }

    private fun logLongJson(tag: String, json: String) {
        val chunkSize = 4000
        var i = 0
        while (i < json.length) {
            val end = (i + chunkSize).coerceAtMost(json.length)
            Log.d(tag, json.substring(i, end))
            i = end
        }
    }

    fun onMovieClick(movieId: Int) {
        sendEvent(MovieListUiEvent.NavigateToDetail(movieId))
    }
}