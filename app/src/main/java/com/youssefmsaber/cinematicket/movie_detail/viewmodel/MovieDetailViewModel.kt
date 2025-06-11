package com.youssefmsaber.cinematicket.movie_detail.viewmodel

import androidx.lifecycle.ViewModel
import com.youssefmsaber.cinematicket.R
import com.youssefmsaber.cinematicket.movie_detail.model.MovieDetails
import com.youssefmsaber.cinematicket.movie_detail.model.Rating
import kotlinx.coroutines.flow.MutableStateFlow

class MovieDetailViewModel : ViewModel() {

    private val fantasticBeastsMovie = MovieDetails(
        movieName = "Fantastic Beasts: The Secrets of Dumbledore",
        ratings = listOf(
            Rating(
                rating = "6.8",
                unit = "/10",
                platform = "IMDb"
            ),
            Rating(
                rating = "63",
                unit = "%",
                platform = "Rotten Tomatoes"
            ),
            Rating(
                rating = "4",
                unit = "/10",
                platform = "IGN"
            ),
        ),
        categories = listOf("Fantasy", "Adventure"),
        actors = listOf(
            R.drawable.actor1,
            R.drawable.actor2,
            R.drawable.actor3,
            R.drawable.actor4,
            R.drawable.actor5,
            R.drawable.actor6,
            R.drawable.actor7,
            R.drawable.actor8,
        ),
        description = "Professor Albus Dumbledore knows the powerful Dark wizard Gellert Grindelwald is moving to seize control of the wizarding world. Unable to stop him alone, he entrusts Magizoologist Newt Scamander to lead an intrepid team of wizards, witches and one brave Muggle baker on a dangerous mission, where they encounter old and new beasts and clash with Grindelwald's growing legion of followers. But with the stakes so high, how long can Dumbledore remain on the sidelines? —Warner Bros",
        duration = "2h 23m"
    )

    private val _movieDetails = MutableStateFlow<MovieDetails>(MovieDetails())
    val movieDetails = _movieDetails

    fun getMovieDetails() {
        _movieDetails.value = fantasticBeastsMovie
    }
}