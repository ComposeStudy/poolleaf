package com.poolleaf.composestudy

import android.content.Context
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.tooling.preview.Preview
import com.poolleaf.composestudy.cupcake.ui.LunchTrayScreen
import com.poolleaf.composestudy.sport.ui.SportsApp
import com.poolleaf.composestudy.sport.utils.WindowStateUtils
import com.poolleaf.composestudy.ui.theme.ComposeStudyTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                val screenState = rememberSaveable { mutableStateOf(WindowStateUtils.ListOnly) }
                val windowSize = calculateWindowSizeClass(this)

                screenState.value = when (windowSize.widthSizeClass) {
                    WindowWidthSizeClass.Compact,
                    WindowWidthSizeClass.Medium -> WindowStateUtils.ListOnly
                    WindowWidthSizeClass.Expanded -> WindowStateUtils.ListAndDetail
                    else -> WindowStateUtils.ListOnly
                }

                SportsApp (windowState = screenState.value)
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeStudyTheme {
        LunchTrayScreen()
    }
}
