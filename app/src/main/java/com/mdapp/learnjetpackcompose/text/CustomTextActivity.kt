package com.mdapp.learnjetpackcompose.text

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class CustomTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShowTextView()
        }
    }
}

@Composable
fun CustomStyledText(
    displayText: String,
    style: TextStyle? = null,
    maxLines: Int? = null
) {
    Text(
        text = displayText,
        modifier = Modifier.padding(16.dp),
        style = style ?: TextStyle.Default,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxLines ?: Int.MAX_VALUE
    )
    Divider(color = Color.Red)
}

@Composable
fun ShowTextView() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .background(color = Color.Gray)
    ) {
        CustomStyledText(
            "This is the default text style"
        )

        CustomStyledText(
            "This text is blue in color",
            // TextStyle allows you to specify styling configuration for a `Text`
            // composable
            style = TextStyle(
                color = Color.Blue
            )
        )

        CustomStyledText(
            "This text has a bigger font size",
            style = TextStyle(
                fontSize = 30.sp
            )
        )

        CustomStyledText(
            "This text is bold",
            style = TextStyle(
                fontWeight = FontWeight.W700
            )
        )

        CustomStyledText(
            "This text is italic",
            style = TextStyle(
                fontStyle = FontStyle.Italic
            )
        )

        CustomStyledText(
            "This text is using a custom font family",
            style = TextStyle(
                fontFamily = FontFamily.Cursive
            )
        )

        CustomStyledText(
            "This text has an underline",
            style = TextStyle(
                textDecoration = TextDecoration.Underline
            )
        )

        CustomStyledText(
            "This text has a strikethrough line",
            style = TextStyle(
                textDecoration = TextDecoration.LineThrough
            )
        )

        CustomStyledText(
            "This text will add an ellipsis to the end " +
                    "of the text if the text is longer that 1 line long.",
            maxLines = 1
        )

        CustomStyledText(
            "This text has a shadow",
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Black, blurRadius = 10f,
                    offset = Offset(2f, 2f)
                )
            )
        )

        // Row is a composable that places its children in a horizontal sequence. You
        // can think of it similar to a LinearLayout with the horizontal orientation.
        // In addition, we pass a modifier to the Row composable. You can think of
        // Modifiers as implementations of the decorators pattern that  are used to
        // modify the composable that its applied to. In this example, we configure the
        // Row to occupify the entire available width using Modifier.fillMaxWidth()
        Row(modifier = Modifier.fillMaxWidth()) {
            // Text is a predefined composable that does exactly what you'd expect it to -
            // display text on the screen. It allows you to customize its appearance using
            // the style property.
            Text(
                text = "This text is center aligned",
                style = TextStyle(
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.padding(16.dp)
            )
        }
        // A pre-defined composable that renders a thin line on the screen that makes it
        // easy to group contents
        Divider(color = Color.Gray)

        CustomStyledText(
            "This text will demonstrate how to justify " +
                    "your paragraph to ensure that the text that ends with a soft " +
                    "line break spreads and takes the entire width of the container",
            style = TextStyle(
                textAlign = TextAlign.Justify
            )
        )

        CustomStyledText(
            "This text will demonstrate how to add " +
                    "indentation to your text. In this example, indentation was only " +
                    "added to the first line. You also have the option to add " +
                    "indentation to the rest of the lines if you'd like",
            style = TextStyle(
                textAlign = TextAlign.Justify,
                textIndent = TextIndent(firstLine = 30.sp)
            )
        )

        CustomStyledText(
            "The line height of this text has been " +
                    "increased hence you will be able to see more space between each " +
                    "line in this paragraph.",
            style = TextStyle(
                textAlign = TextAlign.Justify,
                lineHeight = 20.sp
            )
        )

        val annotatedString = buildAnnotatedString {
            append("This string has style spans")
            addStyle(style = SpanStyle(color = Color.Red), start = 0, end = 4)
            addStyle(style = SpanStyle(color = Color.Green), start = 5, end = 21)
            addStyle(style = SpanStyle(color = Color.Blue), start = 22, end = 27)
        }
        Text(annotatedString, modifier = Modifier.padding(16.dp))
        // A pre-defined composable that renders a thin line on the screen that makes it
        // easy to group contents
        Divider(color = Color.Gray)

        // Surface is a composable provided to fulfill the needs of the "Surface"
        // metaphor from the Material Design specification. It's generally used to
        // change the background color, add elevation, clip or add background shape
        // to its children composables.
        Surface(color = Color.Yellow) {
            Text(
                text = "This text has a background color",
                modifier = Modifier.padding(16.dp)
            )
        }
    }

}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun CustomStyleTextPreview() {
    ShowTextView()
}
