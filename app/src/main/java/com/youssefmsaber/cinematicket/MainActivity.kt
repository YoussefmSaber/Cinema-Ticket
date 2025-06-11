package com.youssefmsaber.cinematicket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.youssefmsaber.cinematicket.movie_detail.MovieDetailScreen
import com.youssefmsaber.cinematicket.ui.theme.CinemaTicketTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, true)
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = true
        enableEdgeToEdge()
        setContent {
            CinemaTicketTheme {
//                HomeScreen()
                MovieDetailScreen()
            }
        }
    }
}