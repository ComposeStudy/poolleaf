package com.poolleaf.composestudy.sport

import androidx.lifecycle.ViewModel
import com.poolleaf.composestudy.sport.data.SportUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SportViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(SportUiState(emptyList()))
    val uiState = _uiState.asStateFlow()

    fun updateSportUiState() {

    }
}