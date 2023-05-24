package com.poolleaf.composestudy.frog.data.repository.impl

import com.poolleaf.composestudy.frog.data.repository.FrogRepository
import com.poolleaf.composestudy.frog.data.service.FrogService
import javax.inject.Inject

class FrogRepositoryImpl @Inject constructor(
    private val frogService: FrogService
): FrogRepository {
    override suspend fun getFrogList() = frogService.getFrogList()
}