package com.poolleaf.composestudy

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.poolleaf.composestudy.hero.model.HeroData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroCard(
    modifier: Modifier,
    hero: HeroData,
    heroNameTextStyle: TextStyle = MaterialTheme.typography.headlineMedium,
    heroDescriptionTextStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    heroThumbnailRadius: Dp = 8.dp,
    cardRadius: Dp = 16.dp,
    cardElevation: Dp = 2.dp,
    cardPadding: Dp = 16.dp
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(
            defaultElevation = cardElevation
        ),
        shape = RoundedCornerShape(cardRadius),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF596148)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(cardPadding)
                .sizeIn(minHeight = 72.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = hero.name,
                    style = heroNameTextStyle
                )
                Text(
                    text = hero.description,
                    style = heroDescriptionTextStyle
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(heroThumbnailRadius))
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = hero.thumbnail),
                    contentDescription = "Hero Image",
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}
