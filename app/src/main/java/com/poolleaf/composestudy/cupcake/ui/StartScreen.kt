package com.poolleaf.composestudy.cupcake.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun StartScreen(
    onNavigateToEntree: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
        content = {
            Button(
                modifier = Modifier.wrapContentSize(),
                onClick = { onNavigateToEntree() }
            ) {
                Text(text = "Start Order")
            }
        }
    )
}
