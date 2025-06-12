package com.youssefmsaber.cinematicket.ticket_booking.model

data class SeatModel(
    val id: Int,
    val lineNumber: Int,
    val seatState: SeatState = SeatState.Available,
) {
    enum class SeatState {
        Available, Selected, Taken
    }
}
