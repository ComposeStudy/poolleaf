package com.poolleaf.composestudy.cupcake.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.poolleaf.composestudy.cupcake.datasource.CupCakeDataSource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LunchTrayScreen() {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = CupCakeScreen.valueOf(
        backStackEntry?.destination?.route ?: CupCakeScreen.Start.name
    )
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    Text(
                        text = if (currentScreen.title != CupCakeScreen.Start.title) {
                            currentScreen.title
                        } else {
                            "Lunch Tray"
                        },
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyLarge
                    )
                },
                navigationIcon = {
                    if (navController.previousBackStackEntry != null) {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }
                }
            )
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = CupCakeScreen.Start.title,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(route = CupCakeScreen.Start.title) {
                StartScreen(
                    onNavigateToEntree = {
                        navController.navigate(CupCakeScreen.Entree.title)
                    }
                )
            }
            composable(route = CupCakeScreen.Entree.title) {
                EntreeScreen(
                    onNextButtonClicked = {
                        navController.navigate(CupCakeScreen.SideDish.title)
                    },
                    onCancelButtonClicked = {
                        navController.navigateUp()
                    }
                )
            }
            composable(route = CupCakeScreen.SideDish.title) {
                SideDishScreen(
                    onNextButtonClicked = {
                        navController.navigate(CupCakeScreen.Acomppaniment.title)
                    },
                    onCancelButtonClicked = {
                        navController.navigateUp()
                    }
                )
            }
            composable(route = CupCakeScreen.Acomppaniment.title) {
                AccompanimentScreen(
                    onNextButtonClicked = {
                        navController.navigate(CupCakeScreen.Checkout.title)
                    },
                    onCancelButtonClicked = {
                        navController.navigateUp()
                    }
                )
            }
            composable(route = CupCakeScreen.Checkout.title) {
                CheckOutScreen(
                    entreeItem = CupCakeDataSource.entreeMenuItems[0],
                    sideDishItem = CupCakeDataSource.sideDishMenuItems[0],
                    accompanimentItem = CupCakeDataSource.accompanimentMenuItems[0],
                    onCancelButtonClicked = {
                        navController.navigateUp()
                    },
                    onSubmitButtonClicked = {
                        navController.navigate(CupCakeScreen.Start.title)
                    },
                    modifier = Modifier.wrapContentSize().padding(16.dp)
                )
            }
        }
    }
}
