package com.poolleaf.composestudy.frog.domain

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poolleaf.composestudy.frog.domain.model.FrogInfo
import com.poolleaf.composestudy.frog.ui.FrogUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import java.io.IOException

@HiltViewModel
class FrogListViewModel @Inject constructor(
    private val getFrogListUseCase: GetFrogListUseCase
): ViewModel() {
    private val _uiState = mutableStateOf<FrogUiState>(FrogUiState.Loading)
    val uiState = _uiState

    fun getFrogList() {
        viewModelScope.launch {
            runCatching {
                getFrogListUseCase.invoke()
            }.onSuccess {
                _uiState.value = it
            }.onFailure {
                _uiState.value = FrogUiState.Fail
            }
        }
    }
}