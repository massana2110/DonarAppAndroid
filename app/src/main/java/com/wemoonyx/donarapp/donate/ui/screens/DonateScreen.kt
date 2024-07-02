package com.wemoonyx.donarapp.donate.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wemoonyx.donarapp.home.ui.components.HomeCategories
import com.wemoonyx.donarapp.home.ui.components.categoryItems
import com.wemoonyx.donarapp.ui.theme.GrayPrimary
import com.wemoonyx.donarapp.ui.theme.GrayTertiary
import com.wemoonyx.donarapp.ui.theme.LightGraySecondary
import com.wemoonyx.donarapp.ui.theme.interFontFamily

@Composable
fun DonateScreen(modifier: Modifier = Modifier) {

    var searchText by remember {
        mutableStateOf("")
    }

    Column(modifier = modifier) {
        DonateSearch(modifier = Modifier.padding(16.dp), searchText = searchText) {
            searchText = it
        }

        HomeCategories(categoryItems)
        DonationList()
    }
}

@Composable
fun DonateSearch(
    modifier: Modifier = Modifier,
    searchText: String,
    onSearchTextChange: (String) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(40.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(GrayTertiary.copy(0.2f)),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            modifier = Modifier.padding(horizontal = 4.dp),
            imageVector = Icons.Outlined.Search,
            contentDescription = "Search",
            alpha = 0.4f
        )

        BasicTextField(
            modifier = Modifier.weight(1f),
            value = searchText,
            singleLine = true,
            maxLines = 1,
            textStyle = TextStyle(
                color = GrayPrimary,
                fontFamily = interFontFamily,
                fontWeight = FontWeight.Normal
            ),
            onValueChange = { onSearchTextChange(it) }) { innerTextField ->

            if (searchText.isEmpty()) {
                Text(
                    text = "Busca por nombre o tema de interes",
                    fontSize = 13.sp,
                    color = LightGraySecondary,
                    fontFamily = interFontFamily,
                    fontWeight = FontWeight.Normal
                )
            }
            innerTextField()
        }
    }
}

@Composable
fun DonationList(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        item {
            Text(
                text = "Resultados de todo",
                fontFamily = interFontFamily,
                fontWeight = FontWeight.Medium,
                color = GrayPrimary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "40 resultados",
                fontFamily = interFontFamily,
                fontWeight = FontWeight.Medium,
                color = LightGraySecondary,
                fontSize = 12.sp
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun DonateScreenPreview() {
    DonateScreen()
}