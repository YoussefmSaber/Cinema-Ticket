package com.youssefmsaber.cinematicket.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.youssefmsaber.cinematicket.R
import com.youssefmsaber.cinematicket.composable.Chip
import com.youssefmsaber.cinematicket.composable.MovieCategories
import com.youssefmsaber.cinematicket.home.composable.BlurredImage
import com.youssefmsaber.cinematicket.home.composable.BottomBarItem
import com.youssefmsaber.cinematicket.home.composable.HorizontalHomePager
import com.youssefmsaber.cinematicket.home.composable.MovieDuration
import com.youssefmsaber.cinematicket.home.composable.MovieName
import com.youssefmsaber.cinematicket.home.model.Movie
import com.youssefmsaber.cinematicket.home.viewmodel.HomeViewModel
import com.youssefmsaber.cinematicket.ui.theme.Black
import com.youssefmsaber.cinematicket.ui.theme.Grey
import com.youssefmsaber.cinematicket.ui.theme.Orange
import com.youssefmsaber.cinematicket.ui.theme.White
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = koinViewModel()) {
    viewModel.getMovies()
    val movies by viewModel.movies.collectAsStateWithLifecycle()
    HomeScreenContent(
        movies = movies
    )
}

@Composable
fun HomeScreenContent(
    movies: List<Movie>
) {
    val pagerState = rememberPagerState(initialPage = 1, pageCount = { movies.size })
    Box {
        BlurredImage(
            modifier = Modifier
                .fillMaxWidth()
                .background(White),
            imageId = movies[pagerState.currentPage].image
        )
        LazyColumn(
            modifier = Modifier
                .windowInsetsPadding(WindowInsets.statusBars)
                .padding(top = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Chip(
                        modifier = Modifier,
                        text = "Now Showing",
                        borderWidth = 0.dp,
                        backgroundColor = Orange,
                        textColor = White,
                        borderColor = Color.Transparent
                    )
                    Chip(
                        modifier = Modifier,
                        text = "Coming Soon",
                        borderWidth = 1.dp,
                        backgroundColor = Color.Transparent,
                        borderColor = Grey,
                        textColor = Color.White
                    )
                }
            }
            item {
                HorizontalHomePager(pagerState, movies)
            }
            item {
                MovieDuration(
                    movieDuration = movies[pagerState.currentPage].duration,
                    textSize = 16.sp,
                    iconSize = 24.dp
                )
            }
            item {
                MovieName(movieName = movies[pagerState.currentPage].name)
            }
            item {
                MovieCategories(movies[pagerState.currentPage].category)
            }
        }
        Row(
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 16.dp)
                .fillMaxWidth()
                .background(White)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomBarItem(
                modifier = Modifier,
                icon = R.drawable.movie,
                iconTint = White,
                backgroundColor = Orange
            )
            BottomBarItem(
                modifier = Modifier,
                icon = R.drawable.search,
                iconTint = Black,
                backgroundColor = Color.Transparent
            )
            BadgedBox(
                badge = {
                    Badge(
                        modifier = Modifier.offset(y = 22.dp),
                        containerColor = Orange,
                        contentColor = White
                    ) {
                        Text("5", fontSize = 12.sp)
                    }
                }
            ) {
                BottomBarItem(
                    modifier = Modifier,
                    icon = R.drawable.ticket,
                    iconTint = Black,
                    backgroundColor = Color.Transparent
                )
            }

            BottomBarItem(
                modifier = Modifier,
                icon = R.drawable.profile,
                iconTint = Black,
                backgroundColor = Color.Transparent
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreenContent(
        movies = listOf(
            Movie(
                id = 1,
                name = "Morbius",
                image = R.drawable.morbius,
                category = listOf("Action", "Horror"),
                duration = "1h 46m"
            ),
            Movie(
                id = 1,
                name = "Fantastic Beasts: The Secrets of Dumbledore",
                image = R.drawable.fantastic_beasts,
                category = listOf("Action", "Horror"),
                duration = "1h 46m"
            ),
            Movie(
                id = 1,
                name = "Dr. Strange in the Multiverse of Madness",
                image = R.drawable.dr_strange,
                category = listOf("Action", "Horror"),
                duration = "1h 46m"
            )
        )
    )
}