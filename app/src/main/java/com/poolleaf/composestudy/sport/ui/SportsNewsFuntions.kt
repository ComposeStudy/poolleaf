package com.poolleaf.composestudy.sport.ui

import android.app.Activity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.sports.model.Sport
import com.poolleaf.composestudy.R
import com.poolleaf.composestudy.sport.data.LocalSportsDataProvider
import com.poolleaf.composestudy.sport.utils.WindowStateUtils

@Composable
fun CreateSportsBox(
    modifier: Modifier,
    windowStateUtils: WindowStateUtils,
    item: Sport
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(0.5.dp, Color.Black)
    ) {
        Row(modifier = modifier) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                painter = painterResource(id = item.imageResourceId),
                contentDescription = "thumbnail"
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(2f)
                    .padding(8.dp)
            ) {
                Text(
                    modifier = Modifier.wrapContentSize(),
                    text = stringResource(item.titleResourceId),
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(item.subtitleResourceId),
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(verticalAlignment = Alignment.Bottom) {
                    Text(
                        text = AnnotatedString(text = "${item.playerCount} players"),
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    if (item.olympic) {
                        Text(
                            text = AnnotatedString(text = "Olympics"),
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreViewSportsDetails() {
    val sport = LocalSportsDataProvider.defaultSport
    SportsDetails(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        item = sport,
        onBackButtonClick = {}
    )
}

@Preview
@Composable
fun PreviewSportList() {
    SportsList(Modifier.wrapContentSize())
}

@Preview
@Composable
fun PreviewSportListAndDetail() {
    SportsApp(WindowStateUtils.ListOnly)
}

@Composable
fun SportsDetails(
    modifier: Modifier,
    item: Sport,
    onBackButtonClick: () -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                painter = painterResource(id = item.sportsImageBanner),
                contentDescription = "sport banner"
            )
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(8.dp)
            ) {
                Text(
                    text = stringResource(id = item.titleResourceId),
                    style = TextStyle(
                        color = Color.White
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row {
                    Text(
                        text = AnnotatedString(text = "${item.playerCount} players"),
                        style = TextStyle(
                            color = Color.White
                        )
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    if (item.olympic) {
                        Text(
                            text = AnnotatedString(text = "Olympics"),
                            style = TextStyle(
                                color = Color.White
                            )
                        )
                    }
                }
            }
        }
        Surface {
            Text(
                modifier = Modifier.padding(24.dp),
                text = stringResource(id = item.sportDetails)
            )
        }
    }
}

@Composable
fun SportsList(
    modifier: Modifier
) {
    val listOfSport = LocalSportsDataProvider.getSportsData()
    LazyColumn(
        modifier = modifier.padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(listOfSport.size) { sport ->
            CreateSportsBox(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(align = CenterVertically, unbounded = true),
                WindowStateUtils.ListOnly,
                listOfSport[sport]
            )
        }
    }
}

@Composable
fun SportsAppBar(
    onBackButtonClick: () -> Unit,
    screenState: WindowStateUtils
) {
    SmallTopAppBar(
        title = {
            Text(
                text =
                if (screenState != WindowStateUtils.ListOnly) {
                    stringResource(R.string.detail_fragment_label)
                } else {
                    stringResource(R.string.list_fragment_label)
                },
                fontWeight = FontWeight.Bold
            )
        },
        navigationIcon = {
            if (screenState == WindowStateUtils.ListOnly) {
                IconButton(onClick = onBackButtonClick) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            } else {
                Box(modifier = Modifier.width(0.dp).height(0.dp)) {

                }
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SportsApp(windowState: WindowStateUtils) {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            SportsAppBar(
                onBackButtonClick = { navController.popBackStack() },
                screenState = windowState
            )
        },
        content = { paddingValues ->
            if(windowState == WindowStateUtils.ListOnly) {
                SportsList(modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddingValues))
            } else {
                SportListAndDetail(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(paddingValues)
                )
            }
        }
    )
}

@Composable
fun SportListAndDetail(
    modifier: Modifier
) {
    Row(modifier = modifier) {
        SportsList(Modifier.weight(1f))
        val activity = (LocalContext.current as Activity)
        SportsDetails(
            modifier = Modifier.weight(1f),
            item = LocalSportsDataProvider.defaultSport,
            onBackButtonClick = { activity.finish() }
        )
    }
}