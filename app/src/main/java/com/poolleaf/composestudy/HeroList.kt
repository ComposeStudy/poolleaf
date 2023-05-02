package com.poolleaf.composestudy

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.poolleaf.composestudy.model.HeroData

@Composable
fun HeroList(
    modifier: Modifier,
    heroList: List<HeroData>
) {
    LazyColumn {
        items(heroList) { hero ->
            HeroCard(
                modifier = modifier,
                hero = hero
            )
        }
    }
}
