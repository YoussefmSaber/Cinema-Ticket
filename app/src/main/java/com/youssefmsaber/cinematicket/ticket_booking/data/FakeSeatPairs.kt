package com.youssefmsaber.cinematicket.ticket_booking.data

import com.youssefmsaber.cinematicket.ticket_booking.model.SeatModel

val fakeSeatPairs = listOf(
    Pair(
        SeatModel(id = 1, lineNumber = 1),
        SeatModel(id = 2, lineNumber = 1)
    ),
    Pair(
        SeatModel(id = 3, lineNumber = 2),
        SeatModel(id = 4, lineNumber = 2)
    ),
    Pair(
        SeatModel(id = 5, lineNumber = 3, seatState = SeatModel.SeatState.Taken),
        SeatModel(id = 6, lineNumber = 3)
    ),
    Pair(
        SeatModel(id = 7, lineNumber = 1),
        SeatModel(id = 8, lineNumber = 1)
    ),
    Pair(
        SeatModel(id = 9, lineNumber = 2, seatState = SeatModel.SeatState.Selected),
        SeatModel(id = 10, lineNumber = 2, seatState = SeatModel.SeatState.Selected)
    ),
    Pair(
        SeatModel(id = 11, lineNumber = 3),
        SeatModel(id = 12, lineNumber = 3)
    ),
    Pair(
        SeatModel(id = 13, lineNumber = 1, seatState = SeatModel.SeatState.Taken),
        SeatModel(id = 14, lineNumber = 1)
    ),
    Pair(
        SeatModel(id = 15, lineNumber = 2, seatState = SeatModel.SeatState.Selected),
        SeatModel(id = 16, lineNumber = 2, seatState = SeatModel.SeatState.Selected)
    ),
    Pair(
        SeatModel(id = 17, lineNumber = 3, seatState = SeatModel.SeatState.Taken),
        SeatModel(id = 18, lineNumber = 3, seatState = SeatModel.SeatState.Taken)
    ),
    Pair(
        SeatModel(id = 19, lineNumber = 1),
        SeatModel(id = 20, lineNumber = 1)
    ),
    Pair(
        SeatModel(id = 21, lineNumber = 2, seatState = SeatModel.SeatState.Taken),
        SeatModel(id = 22, lineNumber = 2, seatState = SeatModel.SeatState.Taken)
    ),
    Pair(
        SeatModel(id = 23, lineNumber = 3),
        SeatModel(id = 24, lineNumber = 3)
    ),
    Pair(
        SeatModel(id = 25, lineNumber = 1, seatState = SeatModel.SeatState.Taken),
        SeatModel(id = 26, lineNumber = 1, seatState = SeatModel.SeatState.Taken)
    ),
    Pair(
        SeatModel(id = 27, lineNumber = 2, seatState = SeatModel.SeatState.Taken),
        SeatModel(id = 28, lineNumber = 2, seatState = SeatModel.SeatState.Taken)
    ),
    Pair(
        SeatModel(id = 29, lineNumber = 3),
        SeatModel(id = 30, lineNumber = 3)
    )
)