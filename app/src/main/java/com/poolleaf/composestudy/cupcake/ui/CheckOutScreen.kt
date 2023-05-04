package com.poolleaf.composestudy.cupcake.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.poolleaf.composestudy.cupcake.datasource.CupCakeDataSource
import com.poolleaf.composestudy.cupcake.model.MenuItem

@Composable
fun CheckOutScreen(
    entreeItem: MenuItem.EntreeItem,
    sideDishItem: MenuItem.SideDishItem,
    accompanimentItem: MenuItem.AccompanimentItem,
    onCancelButtonClicked: () -> Unit,
    onSubmitButtonClicked: () -> Unit,
    modifier: Modifier
) {
    val subTotal = entreeItem.price + sideDishItem.price + accompanimentItem.price
    val tax = "%.1f".format(subTotal * 0.08)
    Surface(modifier = modifier.wrapContentSize()) {
        Column(modifier = modifier.wrapContentSize()) {
            Text(
                modifier = Modifier.padding(bottom = 16.dp),
                text = "Order Summary",
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.titleSmall
            )

            Row(
                modifier = Modifier.wrapContentSize()
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth().weight(1f),
                    text = entreeItem.name,
                    textAlign = TextAlign.Start
                )
                Text(
                    modifier = Modifier.fillMaxWidth().weight(1f),
                    text = AnnotatedString("$${entreeItem.price}"),
                    textAlign = TextAlign.End
                )
            }

            Row(modifier = Modifier.wrapContentSize()) {
                Text(
                    modifier = Modifier.fillMaxWidth().weight(1f),
                    text = sideDishItem.name,
                    textAlign = TextAlign.Start
                )
                Text(
                    modifier = Modifier.fillMaxWidth().weight(1f),
                    text = AnnotatedString("$${sideDishItem.price}"),
                    textAlign = TextAlign.End
                )
            }

            Row(modifier = Modifier.wrapContentSize()) {
                Text(
                    modifier = Modifier.fillMaxWidth().weight(1f),
                    text = accompanimentItem.name,
                    textAlign = TextAlign.Start
                )
                Text(
                    modifier = Modifier.fillMaxWidth().weight(1f),
                    text = AnnotatedString("$${accompanimentItem.price}"),
                    textAlign = TextAlign.End
                )
            }

            Divider(thickness = 1.dp, modifier = modifier.padding(bottom = 8.dp))

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Subtotal: $$subTotal",
                textAlign = TextAlign.End,
                style = MaterialTheme.typography.bodySmall
            )

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Tax: $$tax",
                textAlign = TextAlign.End,
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Total: $${subTotal + tax.toDouble()}",
                textAlign = TextAlign.End,
                fontWeight = FontWeight.Bold
            )

            Row(
                modifier = modifier,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                OutlinedButton(
                    modifier = Modifier.weight(1f),
                    onClick = onCancelButtonClicked
                ) {
                    Text("Cancel")
                }
                Button(
                    modifier = Modifier.weight(1f),
                    onClick = onSubmitButtonClicked
                ) {
                    Text("Submit")
                }
            }
        }
    }
}

@Preview
@Composable
fun PreViewCheckOut() {
    CheckOutScreen(
        entreeItem = CupCakeDataSource.entreeMenuItems[0],
        sideDishItem = CupCakeDataSource.sideDishMenuItems[0],
        accompanimentItem = CupCakeDataSource.accompanimentMenuItems[0],
        onCancelButtonClicked = {
//            navController.navigateUp()
        },
        onSubmitButtonClicked = {
//            navController.navigate(CupCakeScreen.Start.title)
        },
        modifier = Modifier.wrapContentSize().padding(16.dp)
    )
}
