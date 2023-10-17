package com.mdapp.learnjetpackcompose.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mdapp.learnjetpackcompose.R

@Preview(showSystemUi = true, showBackground = false)
@Composable
fun LemonAppPreview() {
    LemonApp()
}

@Composable
fun LemonApp() {
    var currentStep by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(MaterialTheme.colors.primary),
        color = MaterialTheme.colors.background
    ) {
        when (currentStep) {
            1 -> {
                LemonTextAndImage(textLabelResourceId = R.string.lemon_select,
                    drawableResourceId = R.drawable.lemon_tree,
                    contentDescriptionResourceId = R.string.lemon_tree_content_description,
                    onImageClick = {
                        currentStep = 2
                        squeezeCount = (2..4).random()
                    })
            }

            2 -> {
                LemonTextAndImage(textLabelResourceId = R.string.lemon_squeeze,
                    drawableResourceId = R.drawable.lemon_squeeze,
                    contentDescriptionResourceId = R.string.lemon_content_description,
                    onImageClick = {
                        squeezeCount--
                        if (squeezeCount == 0) {
                            currentStep = 3
                        }
                    })
            }

            3 -> {
                LemonTextAndImage(textLabelResourceId = R.string.lemon_drink,
                    drawableResourceId = R.drawable.lemon_drink,
                    contentDescriptionResourceId = R.string.lemonade_content_description,
                    onImageClick = {
                        currentStep = 4
                    })
            }

            4 -> {
                LemonTextAndImage(textLabelResourceId = R.string.lemon_empty_glass,
                    drawableResourceId = R.drawable.lemon_restart,
                    contentDescriptionResourceId = R.string.empty_glass_content_description,
                    onImageClick = {
                        currentStep = 1
                    })
            }
        }
    }
}


@Composable
fun LemonTextAndImage(
    textLabelResourceId: Int,
    drawableResourceId: Int,
    contentDescriptionResourceId: Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                onClick = onImageClick,
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.button_corner_radius)),
                colors = ButtonDefaults.buttonColors(contentColor = MaterialTheme.colors.primaryVariant)
            ) {
                Image(
                    painter = painterResource(id = drawableResourceId),
                    contentDescription = stringResource(contentDescriptionResourceId),
                    modifier = Modifier
                        .width(dimensionResource(id = R.dimen.button_image_width))
                        .height(dimensionResource(id = R.dimen.button_image_height))
                        .padding(dimensionResource(id = R.dimen.button_interior_padding))
                )
            }
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_vertical)))
            Text(
                text = stringResource(id = textLabelResourceId),
                style = MaterialTheme.typography.h1
            )
        }
    }
}