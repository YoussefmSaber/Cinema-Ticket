package com.youssefmsaber.cinematicket.home.model

data class Movie(
    val id: Int,
    val name: String,
    val image: Int,
    val category: List<String>,
    val duration: String,
)