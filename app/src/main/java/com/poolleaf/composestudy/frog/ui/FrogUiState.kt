package com.poolleaf.composestudy.frog.ui

import com.poolleaf.composestudy.frog.domain.model.FrogInfo

sealed interface FrogUiState {
    data class Success(val frogList: List<FrogInfo>): FrogUiState
    object Fail: FrogUiState
    object Loading: FrogUiState
}