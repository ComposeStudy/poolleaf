package com.poolleaf.composestudy.cupcake.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.foundation.Image
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.poolleaf.composestudy.R
import com.poolleaf.composestudy.cupcake.model.MenuItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuListScreen(
    modifier: Modifier,
    list: List<MenuItem>,
    onCancelButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit
) {
    val selectedItemName = rememberSaveable { mutableStateOf("") }

    Column(modifier = modifier) {
        list.forEach { item ->
            Row(
                modifier = modifier
            ) {
                RadioButton(
                    modifier = Modifier.wrapContentSize(),
                    selected = selectedItemName.value == item.name,
                    onClick = { selectedItemName.value = item.name }
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = item.name,
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Text(
                        text = item.description,
                        style = MaterialTheme.typography.bodySmall
                    )
                    Text(
                        text = AnnotatedString("$${item.price}"),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Divider(thickness = 1.dp, modifier = modifier.padding(bottom = 8.dp))
                }
            }
        }
        MenuScreenButtonGroup(
            selectedItemName = selectedItemName.value,
            onCancelButtonClicked = { onCancelButtonClicked() },
            onNextButtonClicked = { onNextButtonClicked() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}

@Composable
fun MenuScreenButtonGroup(
    selectedItemName: String,
    onCancelButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedButton(modifier = Modifier.weight(1f), onClick = onCancelButtonClicked) {
            Text("Cancel")
        }
        Button(
            modifier = Modifier.weight(1f),
            enabled = selectedItemName.isNotEmpty(),
            onClick = onNextButtonClicked
        ) {
            Text("Next")
        }
    }
}


@Preview
@Composable
fun PreviewTest() {
    Test()
}

@Composable
fun Test() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(8.dp)
            .border(BorderStroke(width = 1.dp, color = Color.Blue)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.villain2),
            contentDescription = "",
            modifier = Modifier
                .width(70.dp)
                .height(70.dp),
        )

        Column(
            modifier = Modifier
                .padding(start = 8.dp, top = 8.dp)
                .align(Alignment.Top)
        ) {
            Text(
                style = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                ),
                text = "제목 :sfsfsfsffsfsssf",
                color = Color.Black
            )
        }
    }
}