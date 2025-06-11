package com.youssefmsaber.cinematicket.home.composable

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.youssefmsaber.cinematicket.R
import com.youssefmsaber.cinematicket.ui.theme.Black
import com.youssefmsaber.cinematicket.ui.theme.Grey
import com.youssefmsaber.cinematicket.ui.theme.Roboto

@Composable
fun MovieDuration(
    modifier: Modifier = Modifier,
    movieDuration: String
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.time),
            contentDescription = null,
            tint = Grey
        )
        AnimatedContent(
            targetState = movieDuration,
            label = "AnimatedDuration"
        ) { movieDuration ->
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = movieDuration,
                style = TextStyle(
                    fontSize = 16.sp,
                    letterSpacing = 0.15.sp,
                    fontFamily = Roboto,
                    fontWeight = FontWeight.Medium,
                    color = Black
                )
            )
        }
    }
}

@Preview
@Composable
private fun MovieDurationPreview() {
    MovieDuration(movieDuration = "2h 36m")
}