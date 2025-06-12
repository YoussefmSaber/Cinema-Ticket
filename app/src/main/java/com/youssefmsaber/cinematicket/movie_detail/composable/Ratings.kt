package com.youssefmsaber.cinematicket.movie_detail.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.youssefmsaber.cinematicket.movie_detail.model.Rating
import com.youssefmsaber.cinematicket.ui.theme.Black
import com.youssefmsaber.cinematicket.ui.theme.Grey
import com.youssefmsaber.cinematicket.ui.theme.OpenSans


@Composable
fun MovieRatings(
    modifier: Modifier = Modifier,
    movieRatings: List<Rating>,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        movieRatings.forEach {
            val rating = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Black,
                        fontFamily = OpenSans,
                        fontWeight = FontWeight.Medium
                    )
                ) {
                    append(it.rating)
                }
                withStyle(
                    style = SpanStyle(
                        color = Grey,
                        fontFamily = OpenSans,
                    )
                ) {
                    append(it.unit)
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    modifier = Modifier.padding(bottom = 4.dp),
                    text = rating
                )
                Text(
                    it.platform,
                    style = TextStyle(
                        color = Grey,
                        fontFamily = OpenSans,
                    )
                )
            }
        }
    }
}

@Preview
@Composable
private fun MovieRatingsPreview() {
    MovieRatings(
        movieRatings = listOf(
            Rating(rating = "7.8", unit = "/10", "IMDb"),
            Rating(rating = "7.8", unit = "/10", "IMDb"),
            Rating(rating = "7.8", unit = "/10", "IMDb"),
        )
    )
}