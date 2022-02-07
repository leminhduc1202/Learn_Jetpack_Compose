package com.mdapp.learnjetpackcompose.material

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class AlertDialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                ClickableAddText()
            }
        }
    }
}

@Composable
fun ClickableAddText() {
    var showPopup by remember { mutableStateOf(false) }
    Column(Modifier.clickable(onClick = { showPopup = true }), content = {
        Card(
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier.padding(8.dp),
            backgroundColor = Color.LightGray,
        ) {
            Text(
                text = "Click to see dialog",
                modifier = Modifier.padding(16.dp),
                style = TextStyle(fontSize = 16.sp, fontFamily = FontFamily.Monospace)
            )

        }
    })
    val onPopupDismissed = { showPopup = false }

    if (showPopup) {
        AlertDialog(onDismissRequest = onPopupDismissed, text = {
            Text(text = "Congratulations! You just clicked the text successfully")
        }, confirmButton = {
            Button(onClick = onPopupDismissed) {
                Text(text = "OK")
            }
        })
    }
}

@Composable
@Preview(showSystemUi = true)
fun ClickableTextPreview() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ClickableAddText()
    }
}