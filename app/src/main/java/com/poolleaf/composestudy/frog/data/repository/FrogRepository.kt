package com.poolleaf.composestudy.frog.data.repository

import com.poolleaf.composestudy.frog.data.dto.FrogDto

interface FrogRepository {
    suspend fun getFrogList(): List<FrogDto>
}