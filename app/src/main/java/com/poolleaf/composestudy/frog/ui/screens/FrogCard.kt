package com.poolleaf.composestudy.frog.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.poolleaf.composestudy.R
import com.poolleaf.composestudy.cupcake.ui.CupCakeScreen
import com.poolleaf.composestudy.frog.domain.model.FrogInfo
import com.poolleaf.composestudy.frog.ui.FrogUiState

@Composable
fun FrogCard(
    modifier: Modifier,
    cornerDp: Dp = 4.dp,
    frogInfo: FrogInfo
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp)
            .clip(RoundedCornerShape(cornerDp)),
    ) {
        Column {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "${frogInfo.name} (${frogInfo.type})",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(8.dp),
                text = frogInfo.description
            )

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                painter = rememberAsyncImagePainter(
                    model = frogInfo.imgSrc,
                ), contentDescription = null
            )
        }
    }
}

@Composable
fun FrogListScreen(
    modifier: Modifier,
    frogCardModifier: Modifier,
    list: List<FrogInfo>
) {
    LazyColumn(modifier = modifier) {
        items(list) { item ->
            FrogCard(modifier = frogCardModifier, frogInfo = item)
        }
    }
}

@Composable
fun FrogTopAppBar() {
    SmallTopAppBar(
        title = {
            Text(
                text = "Amphibians",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FrogListScreen(uiState: FrogUiState) {
    Scaffold(
        topBar = {
            FrogTopAppBar()
        }
    ) { paddingValues ->
        when (uiState) {
            is FrogUiState.Success -> {
                FrogListScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    frogCardModifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    list = uiState.frogList
                )
            }

            is FrogUiState.Fail -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Failed",
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            is FrogUiState.Loading -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_loading),
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewFrogCard() {
    FrogCard(
        modifier = Modifier.fillMaxWidth(),
        frogInfo = FrogInfo(
            name = "Great Basin Spadefoot",
            type = "Toad",
            description = "This toad spends most of its life underground due to the arid desert conditions in which it lives. Spadefoot toads earn the name because of their hind legs which are wedged to aid in digging. They are typically grey, green, or brown with dark spots.",
            imgSrc = "https://developer.android.com/codelabs/basic-android-kotlin-compose-amphibians-app/img/great-basin-spadefoot.png"
        )
    )
}
