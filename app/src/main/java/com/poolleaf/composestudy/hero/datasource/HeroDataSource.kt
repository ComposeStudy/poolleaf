package com.poolleaf.composestudy.hero.datasource

import com.poolleaf.composestudy.R
import com.poolleaf.composestudy.hero.model.HeroData

object HeroDataSource {
    val heroList = listOf(
        HeroData(
            name = "Red Lion Ranger",
            description = "Blazing Lion 블레이징 라이온(작열하는 사자) ",
            thumbnail = R.drawable.red
        ),
        HeroData(
            name = "Yellow Eagle Ranger",
            description = "Soaring Eagle 소어링 이글(비상하는 독수리)",
            thumbnail = R.drawable.yellow
        ),
        HeroData(
            name = "Blue Shark Ranger",
            description = "Surging Shark 서징 샤크(용솟음치는 상어)",
            thumbnail = R.drawable.blue
        ),
        HeroData(
            name = "Black Bison Ranger",
            description = "Iron Bison 아이언 바이슨(강철의 바이슨)",
            thumbnail = R.drawable.black
        ),
        HeroData(
            name = "White Tiger Ranger",
            description = "Noble Tiger 노블 타이거(고결한 호랑이)",
            thumbnail = R.drawable.white
        ),
        HeroData(
            name = "Princess Shayla",
            description = "슈라공주",
            thumbnail = R.drawable.princess
        ),
        HeroData(
            name = "Toxica",
            description = "듀크 오그이자, 마스터 오그의 부하. 한 번 쓰러진 오그를 부활시키는 역할을 담당하고 있다",
            thumbnail = R.drawable.villain
        ),
        HeroData(
            name = "Jindrax",
            description = "듀크 오그이자 마스터 오그의 부하.",
            thumbnail = R.drawable.villain2
        )
    )
}