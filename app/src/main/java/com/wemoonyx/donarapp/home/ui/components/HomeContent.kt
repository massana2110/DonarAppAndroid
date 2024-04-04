package com.wemoonyx.donarapp.home.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wemoonyx.donarapp.R
import com.wemoonyx.donarapp.ui.theme.BlueTertiary
import com.wemoonyx.donarapp.ui.theme.YellowPrimary
import com.wemoonyx.donarapp.ui.theme.interFontFamily
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield

data class BannerItem(
    @DrawableRes val image: Int,
    val quantity: Int,
    val title: String,
    val description: String
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeContent(modifier: Modifier) {
    val bannerItems = listOf(
        BannerItem(
            R.drawable.dogs_banner,
            85,
            "Perritos \nalimentados",
            "Gracias a tus donaciones\nen Arani El Salvador"
        ),
        BannerItem(
            R.drawable.garden_banner,
            98,
            "Arboles \nsembrados",
            "Gracias a tus donaciones\nen Fundación Naturaleza"
        ),
        BannerItem(
            R.drawable.dentist_banner,
            50,
            "Consultas \ndentales",
            "A través de su programa\nprimera infancia de FUSAL"
        ),
    )

    val pagerState = rememberPagerState(pageCount = { bannerItems.size })

    LaunchedEffect(Unit) {
        while (true) {
            yield()
            delay(2600)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (pagerState.pageCount)
            )
        }
    }
    Column {
        HomeBanner(modifier, bannerItems = bannerItems, pagerState = pagerState)
        HomeCategories()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeBanner(modifier: Modifier, bannerItems: List<BannerItem>, pagerState: PagerState) {
    Box(
        modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
        HorizontalPager(state = pagerState) {
            Card(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Box {
                    Image(
                        painter = painterResource(id = bannerItems[it].image),
                        contentDescription = bannerItems[it].title,
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
                                text = bannerItems[it].quantity.toString(),
                                fontFamily = interFontFamily,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontSize = 40.sp
                            )
                            Text(
                                text = bannerItems[it].title,
                                fontFamily = interFontFamily,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                modifier = Modifier.padding(start = 4.dp)
                            )
                        }
                        Text(
                            text = bannerItems[it].description,
                            fontFamily = interFontFamily,
                            fontWeight = FontWeight.Normal,
                            color = Color.White,
                            fontSize = 10.sp
                        )
                    }
                }
            }
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerIndicator(pagerState: PagerState, modifier: Modifier) {
    Row(modifier = modifier.padding(bottom = 8.dp)) {
        repeat(pagerState.pageCount) { iteration ->
            val color = if (pagerState.currentPage == iteration) YellowPrimary else BlueTertiary
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(12.dp)
            )
        }

    }
}

@Composable
fun HomeCategories() {
    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp)) {
        Text(
            text = "Dona por categoría",
            fontFamily = interFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        LazyRow {

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