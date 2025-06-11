package com.youssefmsaber.cinematicket.movie_detail.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.youssefmsaber.cinematicket.R
import com.youssefmsaber.cinematicket.home.composable.MovieDuration
import com.youssefmsaber.cinematicket.movie_detail.model.MovieDetails
import com.youssefmsaber.cinematicket.ui.theme.Grey
import com.youssefmsaber.cinematicket.ui.theme.Orange
import com.youssefmsaber.cinematicket.ui.theme.White

@Composable
fun ColumnScope.DetailsHeader(
    modifier: Modifier = Modifier,
    movieDetails: MovieDetails
) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(112.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(R.drawable.close),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Grey.copy(alpha = 0.8f))
                    .padding(8.dp)
                    .size(28.dp),
                tint = White,
            )
            MovieDuration(
                modifier = Modifier
                    .background(Grey.copy(alpha = 0.6f), shape = CircleShape)
                    .padding(4.dp),
                movieDuration = movieDetails.duration,
                textColor = White,
                iconTint = Grey,
                textSize = 14.sp,
                iconSize = 24.dp
            )
        }
        Icon(
            modifier = Modifier
                .background(Orange, shape = CircleShape)
                .padding(12.dp)
                .size(24.dp),
            painter = painterResource(R.drawable.play),
            contentDescription = "Play Movie Button",
            tint = White
        )
    }
}


@Preview
@Composable
fun DetailsHeaderPreview() {
    Column {
        DetailsHeader(
            movieDetails = MovieDetails(
                duration = "2h 23m"
            )
        )
    }
}