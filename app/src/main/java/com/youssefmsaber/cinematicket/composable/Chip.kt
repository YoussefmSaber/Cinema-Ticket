package com.youssefmsaber.cinematicket.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.youssefmsaber.cinematicket.ui.theme.Grey
import com.youssefmsaber.cinematicket.ui.theme.OpenSans
import com.youssefmsaber.cinematicket.ui.theme.White

@Composable
fun Chip(
    modifier: Modifier = Modifier,
    text: String,
    borderWidth: Dp,
    borderColor: Color = Grey,
    backgroundColor: Color = Color.Transparent,
    textColor: Color = White
) {
    Box(
        modifier
            .background(backgroundColor, shape = CircleShape)
            .border(width = borderWidth, color = borderColor, shape = CircleShape)
    ) {
        Text(
            modifier = modifier.padding(horizontal = 12.dp, vertical = 8.dp),
            text = text,
            style = TextStyle(
                color = textColor,
                fontSize = 14.sp,
                fontFamily = OpenSans,
                letterSpacing = 0.15.sp,
                fontWeight = FontWeight.Normal
            )
        )
    }
}

@Preview
@Composable
private fun ChipPreview() {
    Chip(
        text = "Now Showing",
        borderWidth = 1.dp,
    )
}