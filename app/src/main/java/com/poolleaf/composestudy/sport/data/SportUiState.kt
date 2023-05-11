package com.poolleaf.composestudy.sport.data

import com.example.sports.model.Sport

data class SportUiState(
    val sportsList: List<Sport> = emptyList(),
    val currentSport: Sport = LocalSportsDataProvider.defaultSport,
    val isShowingListPage: Boolean = true
)
