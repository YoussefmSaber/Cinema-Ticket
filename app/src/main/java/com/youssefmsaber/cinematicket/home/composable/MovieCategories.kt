package com.youssefmsaber.cinematicket.home.composable

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.youssefmsaber.cinematicket.composable.Chip
import com.youssefmsaber.cinematicket.ui.theme.Black

@Composable
fun MovieCategories(
    movieCategories: List<String>
) {
    AnimatedContent(
        targetState = movieCategories,
        label = "Movie Category"
    ) { category ->
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            category.forEach {
                Chip(
                    modifier = Modifier,
                    text = it,
                    borderWidth = 1.dp,
                    textColor = Black,
                )
            }
        }
    }
}

@Preview
@Composable
private fun MovieCategoriesPreview() {
    MovieCategories(
        listOf("Action", "Horror")
    )
}