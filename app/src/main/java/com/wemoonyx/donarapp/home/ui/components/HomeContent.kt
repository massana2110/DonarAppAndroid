package com.wemoonyx.donarapp.home.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wemoonyx.donarapp.R
import com.wemoonyx.donarapp.ui.theme.interFontFamily

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeContent(modifier: Modifier) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) { 3 }

    HomeBanner(modifier, pagerState = pagerState)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeBanner(modifier: Modifier, pagerState: PagerState) {
    HorizontalPager(state = pagerState) {
        Card(
            shape = RoundedCornerShape(12.dp),
            modifier = modifier
                .fillMaxWidth()
                .height(150.dp)
        ) {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.dogs_banner),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                )

                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(start = 8.dp, bottom = 8.dp),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "85",
                            fontFamily = interFontFamily,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 40.sp
                        )
                        Text(
                            text = "Perritos \nalimentados",
                            fontFamily = interFontFamily,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                    Text(
                        text = "Gracias a tus donaciones \n" +
                            "en Arani El Salvador ",
                        fontFamily = interFontFamily,
                        fontWeight = FontWeight.Normal,
                        color = Color.White,
                        fontSize = 10.sp
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeContentPreview() {
    Surface {
        HomeContent(Modifier.padding(16.dp))
    }
}