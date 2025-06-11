package com.youssefmsaber.cinematicket.movie_detail.model

data class MovieDetails(
    val movieName: String = "",
    val ratings: List<Rating> = emptyList(),
    val categories: List<String> = emptyList(),
    val actors: List<Int> = emptyList(),
    val description: String = "",
    val duration: String = ""
)