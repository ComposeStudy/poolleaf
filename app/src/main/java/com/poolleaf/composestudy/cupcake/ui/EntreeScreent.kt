package com.poolleaf.composestudy.cupcake.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.poolleaf.composestudy.cupcake.datasource.CupCakeDataSource

@Composable
fun EntreeScreen(
    onCancelButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit
) {
    MenuListScreen(
        modifier = Modifier.fillMaxWidth()
            .wrapContentHeight(
                align = Alignment.CenterVertically
            ).padding(8.dp),
        list = CupCakeDataSource.entreeMenuItems,
        onCancelButtonClicked = onCancelButtonClicked,
        onNextButtonClicked = onNextButtonClicked
    )
}
