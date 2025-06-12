package com.youssefmsaber.cinematicket.movie_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.youssefmsaber.cinematicket.R
import com.youssefmsaber.cinematicket.composable.BookingButton
import com.youssefmsaber.cinematicket.composable.MovieCategories
import com.youssefmsaber.cinematicket.movie_detail.composable.DetailsHeader
import com.youssefmsaber.cinematicket.movie_detail.composable.MovieRatings
import com.youssefmsaber.cinematicket.movie_detail.model.MovieDetails
import com.youssefmsaber.cinematicket.movie_detail.model.Rating
import com.youssefmsaber.cinematicket.movie_detail.viewmodel.MovieDetailViewModel
import com.youssefmsaber.cinematicket.ui.theme.Black
import com.youssefmsaber.cinematicket.ui.theme.Roboto
import com.youssefmsaber.cinematicket.ui.theme.White
import org.koin.androidx.compose.koinViewModel

@Composable
fun MovieDetailScreen(viewModel: MovieDetailViewModel = koinViewModel()) {

    viewModel.getMovieDetails()
    val movieDetails by viewModel.movieDetails.collectAsState()

    MovieDetailContent(movieDetails)
}

@Composable
fun MovieDetailContent(
    movieDetails: MovieDetails
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        BannerImage()
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.windowInsetsPadding(WindowInsets.statusBars)
        ) {
            DetailsHeader(
                modifier = Modifier.padding(bottom = 112.dp),
                movieDetails = movieDetails
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(White, shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                    .padding(top = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MovieRatings(
                    modifier = Modifier
                        .padding(bottom = 24.dp)
                        .padding(horizontal = 16.dp),
                    movieRatings = movieDetails.ratings
                )
                MovieTitle(movieDetails)
                MovieCategories(movieDetails.categories)
                ActorsRow(movieDetails)
                MovieDescription(movieDetails)
                BookingButton(text = "Booking")
            }
        }

    }
}

@Composable
private fun ColumnScope.ActorsRow(movieDetails: MovieDetails) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(movieDetails.actors) {
            Image(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(52.dp),
                painter = painterResource(it),
                contentDescription = "Actor Image"
            )
        }
    }
}

@Composable
private fun MovieDescription(movieDetails: MovieDetails) {
    Text(
        modifier = Modifier
            .padding(horizontal = 20.dp),
        text = movieDetails.description,
        style = TextStyle(
            fontSize = 15.sp,
            fontFamily = Roboto,
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.25.sp,
            color = Black,
            textAlign = TextAlign.Center
        ),
        maxLines = 3,
        minLines = 3,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
private fun MovieTitle(movieDetails: MovieDetails) {
    Text(
        modifier = Modifier
            .padding(bottom = 24.dp)
            .padding(horizontal = 16.dp),
        text = movieDetails.movieName,
        style = TextStyle(
            fontSize = 28.sp,
            letterSpacing = 0.15.sp,
            fontFamily = Roboto,
            fontWeight = FontWeight.Normal,
            color = Black,
            textAlign = TextAlign.Center
        )
    )
}

@Composable
private fun BannerImage() {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = (-50).dp),
        painter = painterResource(id = R.drawable.fantastic_beasts_banner),
        contentDescription = "Movie Banner",
        contentScale = ContentScale.FillWidth,
    )
}


@Preview
@Composable
fun MovieDetailScreenPreview() {
    MovieDetailContent(
        MovieDetails(
            duration = "2h 23m",
            movieName = "Fantastic Beasts: The Secrets of Dumbledore",
            ratings = listOf(
                Rating(rating = "7.8", unit = "/10", "IMDb"),
                Rating(rating = "63", unit = "%", "Rotten Tomatoes"),
                Rating(rating = "4", unit = "/10", "IGN"),
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
            description = "Professor Albus Dumbledore knows the powerful, dark wizard Gellert Grindelwald is moving to seize control of the wizarding world. Unable to stop him alone, he entrusts Magizoologist Newt Scamander to lead an intrepid team of wizards, witches and one brave Muggle baker on a dangerous mission, where they encounter old and new beasts and clash with Grindelwald's growing legion of followers. But with the stakes so high, how long can Dumbledore remain on the sidelines? —Warner Bros",

            )
    )
}