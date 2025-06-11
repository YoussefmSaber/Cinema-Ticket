package com.youssefmsaber.cinematicket.home.composable

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.youssefmsaber.cinematicket.ui.theme.Black

@Composable
fun MovieName(
    modifier: Modifier = Modifier,
    movieName: String
) {
    AnimatedContent(
        targetState = movieName,
        label = "AnimatedDuration"
    ) { movieName ->
        Text(
            modifier = modifier.padding(vertical = 16.dp, horizontal = 32.dp),
            text = movieName,
            style = TextStyle(
                fontSize = 30.sp,
                letterSpacing = 0.15.sp,
                fontWeight = FontWeight.Medium,
                color = Black,
                textAlign = TextAlign.Center
            ),
            maxLines = 2,
            minLines = 2
        )
    }
}

@Preview
@Composable
private fun MovieNamePreview() {
    MovieName(movieName = "Morbius")
}