package com.youssefmsaber.cinematicket.ticket_booking.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.youssefmsaber.cinematicket.R
import com.youssefmsaber.cinematicket.ticket_booking.model.SeatModel
import com.youssefmsaber.cinematicket.ui.theme.DarkGrey
import com.youssefmsaber.cinematicket.ui.theme.Orange
import com.youssefmsaber.cinematicket.ui.theme.White

@Composable
fun SeatPair(
    seatPair: Pair<SeatModel, SeatModel>,
    onSeatClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val seatGrouperTint = when {
        seatPair.first.seatState == SeatModel.SeatState.Selected &&
                seatPair.second.seatState == SeatModel.SeatState.Selected -> Orange.copy(0.5f)

        seatPair.first.seatState == SeatModel.SeatState.Taken &&
                seatPair.second.seatState == SeatModel.SeatState.Taken -> DarkGrey.copy(0.7f)

        setOf(seatPair.first.seatState, seatPair.second.seatState)
            .containsAll(
                setOf(
                    SeatModel.SeatState.Selected,
                    SeatModel.SeatState.Taken
                )
            ) -> Orange.copy(0.5f)

        else -> White.copy(0.6f)
    }

    Box(
        modifier = modifier
            .padding(top = 16.dp)
            .graphicsLayer {
                rotationZ = when (seatPair.first.lineNumber) {
                    1 -> 15f
                    3 -> -15f
                    else -> 0f
                }
                translationY = when (seatPair.first.lineNumber) {
                    2 -> 0.dp.value
                    else -> (-32).dp.value
                }
            }) {
        Box(contentAlignment = Alignment.Center) {
            Icon(
                painter = painterResource(R.drawable.seat_grouper),
                contentDescription = null,
                tint = seatGrouperTint,
                modifier = Modifier
                    .scale(1.5f)
                    .padding(top = 6.dp)
            )

            Row(horizontalArrangement = Arrangement.Center) {
                listOf(seatPair.first, seatPair.second).forEach { seat ->
                    Icon(
                        painter = painterResource(R.drawable.cenima_seat),
                        contentDescription = "Seat Icon",
                        tint = when (seat.seatState) {
                            SeatModel.SeatState.Taken -> DarkGrey
                            SeatModel.SeatState.Selected -> Orange
                            SeatModel.SeatState.Available -> White
                        },
                        modifier = Modifier
                            .size(42.dp)
                            .clickable(
                                enabled = seat.seatState != SeatModel.SeatState.Taken,
                                onClick = { onSeatClick(seat.id) }
                            )
                    )
                }
            }
        }
    }
}