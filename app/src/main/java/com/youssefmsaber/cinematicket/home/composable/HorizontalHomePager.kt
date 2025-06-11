package com.youssefmsaber.cinematicket.home.composable

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.youssefmsaber.cinematicket.R
import com.youssefmsaber.cinematicket.home.model.Movie

@Composable
fun HorizontalHomePager(
    pagerState: PagerState,
    movies: List<Movie>
) {
    HorizontalPager(
        modifier = Modifier,
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 50.dp, vertical = 24.dp),
        pageSpacing = (-8).dp
    ) { page ->
        val scale = animateFloatAsState(
            targetValue = if (page == pagerState.currentPage) 1f else 0.8f
        ).value

        Box(
            modifier = Modifier
                .scale(scale)
                .height(450.dp)
        ) {
            Image(
                modifier = Modifier.clip(RoundedCornerShape(20.dp)),
                painter = painterResource(id = movies[page].image),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview
@Composable
fun HorizontalHomePagerPreview() {
    HorizontalHomePager(
        pagerState = PagerState { 2 },
        movies = listOf(
            Movie(
                id = 1,
                name = "Morbius",
                image = R.drawable.morbius,
                category = listOf("Action", "Horror"),
                duration = ""
            ),
            Movie(
                id = 2,
                name = "Morbius",
                image = R.drawable.morbius,
                category = listOf("Action", "Horror"),
                duration = ""
            )
        )
    )
}