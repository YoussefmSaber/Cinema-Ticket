package com.youssefmsaber.cinematicket.home.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.youssefmsaber.cinematicket.R
import com.youssefmsaber.cinematicket.ui.theme.Orange
import com.youssefmsaber.cinematicket.ui.theme.White


@Composable
fun BottomBarItem(
    modifier: Modifier = Modifier,
    icon: Int,
    iconTint: Color,
    backgroundColor: Color,
) {
    Icon(
        modifier = modifier
            .background(backgroundColor, shape = CircleShape)
            .padding(12.dp)
            .size(32.dp),
        painter = painterResource(icon),
        contentDescription = "Bottom Bar Item",
        tint = iconTint
    )
}

@Preview
@Composable
private fun BottomBarItemPreview() {
    BottomBarItem(
        icon = R.drawable.movie,
        iconTint = White,
        backgroundColor = Orange
    )
}