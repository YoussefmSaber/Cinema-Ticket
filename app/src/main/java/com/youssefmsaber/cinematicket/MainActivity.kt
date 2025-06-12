package com.youssefmsaber.cinematicket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.youssefmsaber.cinematicket.ticket_booking.TicketBookingScreen
import com.youssefmsaber.cinematicket.ui.theme.CinemaTicketTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(Color.White.toArgb())
        )
        setContent {
            CinemaTicketTheme {
//                HomeScreen()
//                MovieDetailScreen()
                TicketBookingScreen()
            }
        }
    }
}