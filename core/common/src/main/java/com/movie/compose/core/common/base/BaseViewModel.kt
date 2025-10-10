package com.movie.compose.core.common.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class BaseViewModel<UiState : BaseUiState, UiEvent : BaseUiEvent>(
    initialState: UiState
) : ViewModel() {

    private val _uiState = MutableStateFlow(initialState)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private val _event = MutableSharedFlow<UiEvent>()
    val event: SharedFlow<UiEvent> = _event.asSharedFlow()

    protected fun updateUi(block: UiState.() -> UiState) {
        _uiState.update(block)
    }

    protected fun launchIO(
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        block: suspend () -> Unit
    ) {
        viewModelScope.launch(dispatcher) {
            try {
                block()
            } catch (e: Exception) {
                handleError(e)
            }
        }
    }

    protected suspend fun <T> withMain(block: suspend () -> T): T {
        return withContext(Dispatchers.Main) { block() }
    }

    protected fun sendEvent(event: UiEvent) {
        viewModelScope.launch { _event.emit(event) }
    }

    protected open fun handleError(e: Exception) {
        e.printStackTrace()
    }
}
