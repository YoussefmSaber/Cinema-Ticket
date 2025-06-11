package com.youssefmsaber.cinematicket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.youssefmsaber.cinematicket.home.HomeScreen
import com.youssefmsaber.cinematicket.ui.theme.CinemaTicketTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CinemaTicketTheme {
                HomeScreen()
            }
        }
    }
}