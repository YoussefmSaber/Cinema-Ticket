package com.youssefmsaber.cinematicket.home.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.youssefmsaber.cinematicket.R

@Composable
fun BlurredImage(
    modifier: Modifier = Modifier,
    imageId: Int
) {
    Image(
        modifier = modifier
            .blur(80.dp)
            .offset(y = (-400).dp)
            .fillMaxSize(),
        painter = painterResource(imageId),
        contentDescription = null,
    )
}

@Preview
@Composable
private fun BlurredImagePreview() {
    BlurredImage(
        modifier = Modifier,
        imageId = R.drawable.dr_strange,
    )
}