package com.poolleaf.composestudy.frog.domain

import com.poolleaf.composestudy.frog.data.repository.FrogRepository
import com.poolleaf.composestudy.frog.domain.mapper.toFrogInfoList
import com.poolleaf.composestudy.frog.ui.FrogUiState
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetFrogListUseCase @Inject constructor(
    private val frogRepository: FrogRepository,
) {
    suspend operator fun invoke() = withContext(Dispatchers.Default) {
        val list = frogRepository.getFrogList().toFrogInfoList()
        FrogUiState.Success(list)
    }
}