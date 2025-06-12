package com.youssefmsaber.cinematicket.ticket_booking.viewmodel

import androidx.lifecycle.ViewModel
import com.youssefmsaber.cinematicket.ticket_booking.data.fakeAvailableHours
import com.youssefmsaber.cinematicket.ticket_booking.data.fakeSeatPairs
import com.youssefmsaber.cinematicket.ticket_booking.data.fakeStreamDays
import com.youssefmsaber.cinematicket.ticket_booking.model.AvailableHours
import com.youssefmsaber.cinematicket.ticket_booking.model.SeatModel
import com.youssefmsaber.cinematicket.ticket_booking.model.StreamDays
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class TicketBookingViewModel : ViewModel() {

    private val _seatPairs = MutableStateFlow<List<Pair<SeatModel, SeatModel>>>(emptyList())
    val seatPairs = _seatPairs

    private val _availableDays = MutableStateFlow<List<StreamDays>>(emptyList())
    val availableDays = _availableDays

    private val _availableHours = MutableStateFlow<List<AvailableHours>>(emptyList())
    val availableHours = _availableHours

    private val _numberOfSelectedSeats = MutableStateFlow<Set<Int>>(emptySet())
    val numberOfSelectedSeat = _numberOfSelectedSeats

    fun loadSeats() {
        _seatPairs.value = fakeSeatPairs
        _availableDays.value = fakeStreamDays
        _availableHours.value = fakeAvailableHours
        loadSelectedSeats(_seatPairs.value)
    }

    fun toggleSeat(seatId: Int, lineNumber: Int) {
        _seatPairs.value = _seatPairs.value.map { pair ->
            val first = if (pair.first.id == seatId && pair.first.lineNumber == lineNumber) {
                val toggled = pair.first.toggle()
                updateSelectedSeatSet(toggled)
                toggled
            } else pair.first

            val second = if (pair.second.id == seatId && pair.second.lineNumber == lineNumber) {
                val toggled = pair.second.toggle()
                updateSelectedSeatSet(toggled)
                toggled
            } else pair.second

            first to second
        }
    }

    fun toggleDay(dayId: Int) {
        _availableDays.value = _availableDays.value.map { day ->
            day.copy(isSelected = day.id == dayId)
        }
    }

    fun toggleHour(hourId: Int) {
        _availableHours.value = _availableHours.value.map { hour ->
            hour.copy(isSelected = hour.id == hourId)
        }
    }

    private fun loadSelectedSeats(pairOfSeats: List<Pair<SeatModel, SeatModel>>) {
        pairOfSeats.forEach { pair ->
            if (pair.first.seatState == SeatModel.SeatState.Selected) {
                updateSelectedSeatSet(pair.first)
            }
            if (pair.second.seatState == SeatModel.SeatState.Selected) {
                updateSelectedSeatSet(pair.second)
            }
        }
    }

    private fun updateSelectedSeatSet(seat: SeatModel) {
        _numberOfSelectedSeats.update { current ->
            when (seat.seatState) {
                SeatModel.SeatState.Selected -> current + seat.id
                SeatModel.SeatState.Available -> current - seat.id
                else -> current
            }
        }
    }

    private fun SeatModel.toggle(): SeatModel {
        return if (seatState == SeatModel.SeatState.Available) {
            copy(seatState = SeatModel.SeatState.Selected)
        } else if (seatState == SeatModel.SeatState.Selected) {
            copy(seatState = SeatModel.SeatState.Available)
        } else this
    }
}
