package com.movie.compose.feature.music.feature.home

import android.util.Log
import com.movie.compose.core.common.base.BaseViewModel
import com.movie.compose.core.model.request.NetworkMusicRequest
import com.movie.compose.domain.model.DomainMusic
import com.movie.compose.domain.usecase.GetMusicUseCase
import com.movie.compose.feature.music.ui.MusicListUiEvent
import com.movie.compose.feature.music.ui.MusicListUiState
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMusicUseCase: GetMusicUseCase
) : BaseViewModel<MusicListUiState, MusicListUiEvent>(MusicListUiState()) {

    fun loadMovies(request: NetworkMusicRequest) {
        launchIO {
            getMusicUseCase(request)
                .onStart { updateUi { copy(isLoading = true, error = null) } }
                .catch { e ->
                    updateUi { copy(isLoading = false, error = e.message) }
                    sendEvent(MusicListUiEvent.ShowToast("Failed: ${e.message}"))
                }
                .collect { movies ->
                    val moshi = Moshi.Builder()
                        .add(KotlinJsonAdapterFactory())
                        .build()
                    val type = Types.newParameterizedType(List::class.java, DomainMusic::class.java)
                    val adapter = moshi.adapter<List<DomainMusic>>(type)
                    logLongJson("MyResponse", adapter.toJson(movies))
                    updateUi { copy(isLoading = false, musics = movies) }
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
        sendEvent(MusicListUiEvent.NavigateToDetail(movieId))
    }
}