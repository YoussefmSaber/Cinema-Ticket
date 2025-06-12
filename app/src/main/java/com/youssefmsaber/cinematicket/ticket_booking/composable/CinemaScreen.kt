package com.youssefmsaber.cinematicket.ticket_booking.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.youssefmsaber.cinematicket.R
import com.youssefmsaber.cinematicket.ui.theme.LightOrange


@Composable
fun CinemaScreen(
    imageRes: Int,
    modifier: Modifier = Modifier
) {
    val topBorderHeightRatio = 0.15f
    val topCurveControlOffset = -30f

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .drawBehind {
                val path = Path().apply {
                    moveTo(0f, size.height * topBorderHeightRatio)
                    quadraticTo(
                        size.width / 2f,
                        topCurveControlOffset,
                        size.width,
                        size.height * topBorderHeightRatio
                    )
                }

                drawPath(
                    path = path,
                    color = LightOrange,
                    style = Stroke(width = 2.dp.toPx())
                )
            }
            .clip(
                GenericShape { size, _ ->
                    moveTo(0f, size.height * topBorderHeightRatio)
                    quadraticTo(
                        size.width / 2f,
                        topCurveControlOffset,
                        size.width,
                        size.height * topBorderHeightRatio
                    )
                    lineTo(size.width, size.height * 0.75f)
                    arcTo(
                        rect = Rect(
                            left = 0f,
                            top = size.height * 0.62f,
                            right = size.width,
                            bottom = size.height * 1f
                        ),
                        startAngleDegrees = 0f,
                        sweepAngleDegrees = -180f,
                        forceMoveTo = false
                    )
                    close()
                }
            )
            .graphicsLayer {
                scaleY = 0.9f
                scaleX = 0.75f
                rotationX = -45f
            }
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
                .offset(y = -50.dp)
        )
    }
}

@Preview
@Composable
private fun CinemaScreenPreview() {
    CinemaScreen(R.drawable.fantastic_beasts_poster)
}