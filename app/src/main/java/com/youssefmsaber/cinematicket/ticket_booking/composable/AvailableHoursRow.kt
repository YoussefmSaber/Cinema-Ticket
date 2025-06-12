package com.youssefmsaber.cinematicket.ticket_booking.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.youssefmsaber.cinematicket.ticket_booking.model.AvailableHours
import com.youssefmsaber.cinematicket.ui.theme.Black
import com.youssefmsaber.cinematicket.ui.theme.Grey
import com.youssefmsaber.cinematicket.ui.theme.LightGrey
import com.youssefmsaber.cinematicket.ui.theme.White

@Composable
fun AvailableHoursRow(
    availableHours: List<AvailableHours>,
    onHourClick: (Int) -> Unit
) {
    LazyRow(
        modifier = Modifier.padding(bottom = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 32.dp)
    ) {
        items(availableHours) {
            Column(
                modifier = Modifier
                    .border(
                        1.dp,
                        if (it.isSelected) Grey else LightGrey,
                        RoundedCornerShape(24.dp)
                    )
                    .clip(RoundedCornerShape(24.dp))
                    .clickable { onHourClick(it.id) }
                    .background(if (it.isSelected) Grey else Color.Transparent)
                    .padding(vertical = 12.dp, horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = it.hour,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = if (it.isSelected) White else Black
                )
            }
        }
    }
}

