package com.mdapp.learnjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mdapp.learnjetpackcompose.ui.theme.LearnJetpackComposeTheme
import com.mdapp.learnjetpackcompose.ui.view.TipTimeApp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            DiceWithButtonAndImage()
//            LemonApp()
            LearnJetpackComposeTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TipTimeApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MessageCard(Message("Duc", "World"))
}

data class Message(
    val author: String, val body: String
)

@Composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Photo here",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(10.dp))

        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = msg.author,
                color = MaterialTheme.colors.primaryVariant,
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = msg.body, color = Color.Red
            )
        }
    }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier) {

    Column(modifier = modifier) {
        Text(text = "Hi there!")
        Text(text = "Thanks for going through the Layouts codelab")
    }

}

@Composable
fun SimpleList() {
    val scrollState = rememberScrollState()

    Column(Modifier.verticalScroll(scrollState)) {
        repeat(100) {
            Text(text = "Item #$it")
        }
    }
}

@Composable
fun LazyList() {
    val scrollState = rememberLazyListState()
    Column {
        Column(
            Modifier
                .fillMaxWidth()
                .border(2.dp, color = Color.Red),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "List",
                fontStyle = FontStyle.Italic,
            )
        }
        Divider(
            Modifier
                .fillMaxWidth()
                .height(2.dp)
        )
        LazyColumn(
            state = scrollState, modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            items(1000) {
                Text(text = "Items #$it")
            }
        }
    }

}




