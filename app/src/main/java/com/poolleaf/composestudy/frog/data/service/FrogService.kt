package com.poolleaf.composestudy.frog.data.service

import com.poolleaf.composestudy.frog.data.dto.FrogDto
import retrofit2.http.GET
import retrofit2.http.Query

interface FrogService {
    @GET("/amphibians")
    suspend fun getFrogList(): List<FrogDto>
}