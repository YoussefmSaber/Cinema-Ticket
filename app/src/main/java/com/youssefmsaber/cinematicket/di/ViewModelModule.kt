package com.youssefmsaber.cinematicket.di

import com.youssefmsaber.cinematicket.home.viewmodel.HomeViewModel
import com.youssefmsaber.cinematicket.movie_detail.viewmodel.MovieDetailViewModel
import com.youssefmsaber.cinematicket.ticket_booking.viewmodel.TicketBookingViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::HomeViewModel)
    viewModelOf(::MovieDetailViewModel)
    viewModelOf(::TicketBookingViewModel)
}