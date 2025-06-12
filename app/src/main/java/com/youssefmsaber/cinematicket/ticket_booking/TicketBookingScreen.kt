package com.youssefmsaber.cinematicket.ticket_booking

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.youssefmsaber.cinematicket.R
import com.youssefmsaber.cinematicket.composable.BookingButton
import com.youssefmsaber.cinematicket.ticket_booking.composable.AvailableDaysRow
import com.youssefmsaber.cinematicket.ticket_booking.composable.AvailableHoursRow
import com.youssefmsaber.cinematicket.ticket_booking.composable.CinemaScreen
import com.youssefmsaber.cinematicket.ticket_booking.composable.SeatPair
import com.youssefmsaber.cinematicket.ticket_booking.composable.SeatsGuide
import com.youssefmsaber.cinematicket.ticket_booking.data.fakeAvailableHours
import com.youssefmsaber.cinematicket.ticket_booking.data.fakeSeatPairs
import com.youssefmsaber.cinematicket.ticket_booking.data.fakeStreamDays
import com.youssefmsaber.cinematicket.ticket_booking.model.AvailableHours
import com.youssefmsaber.cinematicket.ticket_booking.model.SeatModel
import com.youssefmsaber.cinematicket.ticket_booking.model.StreamDays
import com.youssefmsaber.cinematicket.ticket_booking.viewmodel.TicketBookingViewModel
import com.youssefmsaber.cinematicket.ui.theme.Black
import com.youssefmsaber.cinematicket.ui.theme.DarkGrey
import com.youssefmsaber.cinematicket.ui.theme.Grey
import com.youssefmsaber.cinematicket.ui.theme.OpenSans
import com.youssefmsaber.cinematicket.ui.theme.Orange
import com.youssefmsaber.cinematicket.ui.theme.White
import org.koin.androidx.compose.koinViewModel

@Composable
fun TicketBookingScreen(viewModel: TicketBookingViewModel = koinViewModel()) {
    LaunchedEffect(key1 = Unit) {
        viewModel.loadSeats()
    }
    val seatPairs by viewModel.seatPairs.collectAsStateWithLifecycle()
    val availableHours by viewModel.availableHours.collectAsStateWithLifecycle()
    val availableDays by viewModel.availableDays.collectAsStateWithLifecycle()
    val numberOfSelectedSeats by viewModel.numberOfSelectedSeat.collectAsStateWithLifecycle()

    TicketBookingContent(
        seatPairs = seatPairs,
        availableHours = availableHours,
        availableDays = availableDays,
        numberOfSelectedSeats = numberOfSelectedSeats,
        onSeatClick = viewModel::toggleSeat,
        onHourClick = viewModel::toggleHour,
        onDayClick = viewModel::toggleDay
    )
}

@Composable
private fun TicketBookingContent(
    seatPairs: List<Pair<SeatModel, SeatModel>>,
    availableHours: List<AvailableHours>,
    availableDays: List<StreamDays>,
    numberOfSelectedSeats: Set<Int>,
    onSeatClick: (Int, Int) -> Unit,
    onHourClick: (Int) -> Unit,
    onDayClick: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .background(Black)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .wrapContentHeight(unbounded = false)
    ) {
        Icon(
            modifier = Modifier
                .windowInsetsPadding(WindowInsets.statusBars)
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp)
                .clip(CircleShape)
                .background(Grey.copy(alpha = 0.4f))
                .padding(8.dp)
                .size(28.dp),
            painter = painterResource(R.drawable.close),
            contentDescription = null,
            tint = White,
        )
        CinemaScreen(
            modifier = Modifier.alpha(0.8f),
            imageRes = R.drawable.fantastic_beasts_poster
        )
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            maxItemsInEachRow = 3
        ) {
            seatPairs.forEach { seats ->
                SeatPair(
                    seatPair = seats,
                    onSeatClick = { onSeatClick(it, seats.first.lineNumber) }
                )
            }
        }
        Row(
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .padding(top = 32.dp, bottom = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            SeatsGuide(text = "Available", indicationColor = White)
            SeatsGuide(text = "Taken", indicationColor = DarkGrey)
            SeatsGuide(text = "Selected", indicationColor = Orange)
        }
        Column(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxSize()
                .background(
                    White,
                    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                )
                .padding(top = 24.dp)
        ) {
            AvailableDaysRow(availableDays, onDayClick)
            AvailableHoursRow(availableHours, onHourClick)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        "$${numberOfSelectedSeats.size * 50}",
                        style = TextStyle(
                            color = Black,
                            fontSize = 24.sp,
                            fontFamily = OpenSans,
                            fontWeight = FontWeight.Medium
                        ),
                    )
                    Text(
                        text = if (numberOfSelectedSeats.isNotEmpty()) "${numberOfSelectedSeats.size} tickets" else "",
                        style = TextStyle(
                            color = Grey,
                            fontSize = 12.sp,
                            fontFamily = OpenSans,
                            fontWeight = FontWeight.Normal
                        ),
                    )
                }
                BookingButton(text = "Buy tickets")
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun TicketBookingPreview() {
    TicketBookingContent(
        fakeSeatPairs,
        availableHours = fakeAvailableHours,
        availableDays = fakeStreamDays,
        onSeatClick = { _, _ -> },
        onHourClick = {},
        onDayClick = {},
        numberOfSelectedSeats = emptySet<Int>()
    )
}