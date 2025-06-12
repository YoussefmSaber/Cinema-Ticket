package com.youssefmsaber.cinematicket.ticket_booking.model

data class AvailableHours(
    val id: Int,
    val hour: String,
    val isSelected: Boolean,
)
