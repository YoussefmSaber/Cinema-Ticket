package com.youssefmsaber.cinematicket.ticket_booking.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.youssefmsaber.cinematicket.ui.theme.OpenSans
import com.youssefmsaber.cinematicket.ui.theme.White

@Composable
fun SeatsGuide(text: String, indicationColor: Color) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .background(indicationColor, CircleShape)
                .size(12.dp)
        )
        Text(
            text,
            style = TextStyle(
                color = White.copy(0.6f),
                fontSize = 16.sp,
                fontFamily = OpenSans
            )
        )
    }
}