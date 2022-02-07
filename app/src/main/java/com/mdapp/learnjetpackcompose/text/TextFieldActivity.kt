package com.mdapp.learnjetpackcompose.text

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.InternalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mdapp.learnjetpackcompose.core.hideKeyboard

class TextFieldActivity : AppCompatActivity() {
//    @InternalTextApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShowTextField()
        }
    }
}

@Composable
fun ShowTextField() {
    val scrollState = rememberScrollState()
    // Column is a composable that places its children in a vertical sequence. You
    // can think of it similar to a LinearLayout with the vertical orientation.
    Column(
        modifier = Modifier.verticalScroll(scrollState)
    ) {
        // Title Component is a custom composable that we created which is capable of
        // rendering text on the screen in a certain font style & text size.
        TitleComponent("This is a Simple Text Input field")
        SimpleTextInputComponent()

        TitleComponent("This is a TextInput with custom text style")
        CustomStyleTextInputComponent()

        TitleComponent("This is a TextInput suitable for typing numbers")
        NumberTextInputComponent()

        TitleComponent("This is a search view created using TextInput")
        SearchImeActionInputComponent()

        TitleComponent("This is a TextInput that uses a Password Visual Transformation")
        PasswordVisualTransformationInputComponent()

        TitleComponent("This is a filled TextInput field based on Material Design")
        MaterialTextInputComponent()
    }

}

@Composable
fun MaterialTextInputComponent() {
    var textValue by remember { mutableStateOf(TextFieldValue("")) }

    TextField(
        value = textValue,
        onValueChange = { textValue = it },
        label = { Text("Enter Your Name") },
        placeholder = { Text(text = "John Doe") },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    )
}

@Composable
fun PasswordVisualTransformationInputComponent() {
    Surface(color = Color.LightGray, modifier = Modifier.padding(16.dp)) {
        var textValue by remember { mutableStateOf(TextFieldValue("Enter your password here")) }
        BasicTextField(
            value = textValue,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            // Update value of textValue with the latest value of the text field
            onValueChange = {
                textValue = it
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            )
        )
    }
}

@Composable
fun SearchImeActionInputComponent() {
    val context = LocalContext.current
    Surface(
        color = Color.LightGray,
        modifier = Modifier.padding(16.dp),
        shape = RoundedCornerShape(5.dp)
    ) {
        var textValue by remember {
            mutableStateOf(TextFieldValue("Enter your search query here"))
        }
        BasicTextField(
            value = textValue,
            onValueChange = { textValue = it },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = { hideKeyboard(context) })
        )

    }
}

@Composable
fun NumberTextInputComponent() {
    Surface(color = Color.LightGray, modifier = Modifier.padding(16.dp)) {
        var textValue by remember { mutableStateOf(TextFieldValue("123")) }
        BasicTextField(
            value = textValue,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            onValueChange = {
                textValue = it
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
    }
}

@Composable
fun CustomStyleTextInputComponent() {
    Surface(color = Color.LightGray, modifier = Modifier.padding(16.dp)) {
        var textValue by remember { mutableStateOf(TextFieldValue("Enter your text here")) }
        BasicTextField(
            value = textValue,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            textStyle = TextStyle(
                color = Color.Blue,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            ),
            onValueChange = {
                textValue = it
            }
        )
    }
}

@Composable
fun SimpleTextInputComponent() {
    Surface(color = Color.LightGray, modifier = Modifier.padding(16.dp)) {
        var textValue by remember { mutableStateOf(TextFieldValue("Enter your text here")) }
        BasicTextField(
            value = textValue,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            onValueChange = { textValue = it })
    }
}

@Composable
fun TitleComponent(s: String) {
}

@Composable
@Preview(showSystemUi = true )
fun ShowContent(){
    ShowTextField()
}

//@InternalTextApi
//@Preview
//@Composable
//fun SimpleTextInputComponentPreview() {
//    SimpleTextInputComponent()
//}
//
//@InternalTextApi
//@Preview
//@Composable
//fun CustomStyleTextInputComponentPreview() {
//    CustomStyleTextInputComponent()
//}
//
//@InternalTextApi
//@Preview
//@Composable
//fun NumberTextInputComponentPreview() {
//    NumberTextInputComponent()
//}
//
//@InternalTextApi
//@Preview
//@Composable
//fun SearchImeActionInputComponentPreview() {
//    SearchImeActionInputComponent()
//}
//
//@InternalTextApi
//@Preview
//@Composable
//fun PasswordVisualTransformationInputComponentPreview() {
//    PasswordVisualTransformationInputComponent()
//}
//
//@Preview
//@Composable
//fun FilledTextInputComponentPreview() {
//    MaterialTextInputComponent()
//}