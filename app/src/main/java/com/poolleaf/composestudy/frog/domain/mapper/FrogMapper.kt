package com.poolleaf.composestudy.frog.domain.mapper

import com.poolleaf.composestudy.frog.data.dto.FrogDto
import com.poolleaf.composestudy.frog.domain.model.FrogInfo

fun List<FrogDto>.toFrogInfoList(): List<FrogInfo> {
    return this.map {
        FrogInfo(
            description = it.description,
            imgSrc = it.imgSrc,
            name = it.name,
            type = it.type
        )
    }
}