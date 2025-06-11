package com.youssefmsaber.cinematicket.home.composable

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.youssefmsaber.cinematicket.R
import com.youssefmsaber.cinematicket.ui.theme.Black
import com.youssefmsaber.cinematicket.ui.theme.Grey
import com.youssefmsaber.cinematicket.ui.theme.Roboto

@Composable
fun MovieDuration(
    modifier: Modifier = Modifier,
    movieDuration: String,
    textColor: Color = Black,
    iconTint: Color = Grey,
    textSize: TextUnit = 16.sp,
    iconSize: Dp = 32.dp,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Icon(
            modifier = Modifier.size(iconSize),
            painter = painterResource(R.drawable.time),
            contentDescription = null,
            tint = iconTint
        )
        AnimatedContent(
            targetState = movieDuration,
            label = "AnimatedDuration"
        ) { movieDuration ->
            Text(
                text = movieDuration,
                style = TextStyle(
                    fontSize = textSize,
                    letterSpacing = 0.15.sp,
                    fontFamily = Roboto,
                    fontWeight = FontWeight.Medium,
                    color = textColor
                )
            )
        }
    }
}

@Preview
@Composable
private fun MovieDurationPreview() {
    MovieDuration(movieDuration = "2h 36m", textSize = 14.sp, iconSize = 24.dp)
}