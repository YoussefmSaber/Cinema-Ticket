package com.youssefmsaber.cinematicket.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import com.youssefmsaber.cinematicket.ui.theme.OpenSans
import com.youssefmsaber.cinematicket.ui.theme.Orange
import com.youssefmsaber.cinematicket.ui.theme.White


@Composable
fun BookingButton(
    modifier: Modifier = Modifier,
    text: String
) {
    Row(
        modifier = modifier
            .background(Orange, shape = CircleShape)
            .padding(horizontal = 24.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(32.dp),
            painter = painterResource(R.drawable.credit),
            contentDescription = "Credit Card for Booking",
            tint = White
        )
        Text(
            text,
            style = TextStyle(
                fontFamily = OpenSans,
                fontWeight = FontWeight.Medium,
                color = White,
                fontSize = 16.sp
            )
        )
    }
}


@Preview
@Composable
private fun BookingButtonPreview() {
    BookingButton(text = "Buy Tickets")
}