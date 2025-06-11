package com.youssefmsaber.cinematicket.home.viewmodel

import androidx.lifecycle.ViewModel
import com.youssefmsaber.cinematicket.R
import com.youssefmsaber.cinematicket.home.model.Movie
import kotlinx.coroutines.flow.MutableStateFlow

class HomeViewModel : ViewModel() {

    private val moviesList = listOf<Movie>(
        Movie(
            id = 1,
            name = "Morbius",
            image = R.drawable.morbius,
            category = listOf("Action", "Horror"),
            duration = "1h 44m"
        ),
        Movie(
            id = 2,
            name = "Fantastic Beasts: The Secrets of Dumbledore",
            image = R.drawable.fantastic_beasts,
            category = listOf("Adventure", "Fantasy"),
            duration = "2h 23m"
        ),
        Movie(
            id = 3,
            name = "Doctor Strange in the Multiverse of Madness",
            image = R.drawable.dr_strange,
            category = listOf("Adventure", "Fantasy"),
            duration = "2h 6m"
        )
    )

    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies = _movies

    fun getMovies() {
        _movies.value = moviesList
    }
}
