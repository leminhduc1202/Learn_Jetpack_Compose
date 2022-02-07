package com.mdapp.learnjetpackcompose.layout

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mdapp.learnjetpackcompose.core.LOREM_IPSUM_1
import com.mdapp.learnjetpackcompose.core.LOREM_IPSUM_2
import com.mdapp.learnjetpackcompose.core.LOREM_IPSUM_3
import com.mdapp.learnjetpackcompose.core.colors

class LayoutModifierActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnView()
        }
    }
}

@Composable
fun LazyColumnView() {
    LazyColumn(modifier = Modifier.padding(5.dp)) {
        item { SamePaddingComponent() }
        item { CustomPaddingComponent() }
        item { OffSetComponent() }
        item { AspectRatioComponent() }
    }

}


@Composable
fun SamePaddingComponent() {
    Surface(color = colors[0]) {
        Text(
            text = LOREM_IPSUM_1,
            modifier = Modifier.padding(16.dp),
            style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Cursive)
        )
    }
}

@Composable
fun CustomPaddingComponent() {
    Surface(color = colors[1]) {
        Text(
            text = LOREM_IPSUM_1,
            modifier = Modifier.padding(32.dp, 32.dp, 4.dp, 0.dp),
            style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Serif)
        )
    }
}

@Composable
fun OffSetComponent() {
    Surface(color = colors[2], modifier = Modifier.offset(8.dp, 8.dp)) {
        Text(
            text = LOREM_IPSUM_1,
            style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Monospace)
        )
    }
}

@Composable
fun AspectRatioComponent() {
    Surface(
        color = colors[3], modifier = Modifier
            .aspectRatio(16 / 9f)
            .padding(top = 16.dp)
    ) {
        Text(
            text = "This text is wrapped in a layout that has a fixed aspect ratio of 16/9",
            style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.SansSerif),
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
@Preview(showSystemUi = true)
fun ShowLazyColumn() {
    LazyColumnView()
}

