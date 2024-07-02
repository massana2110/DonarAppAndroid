package com.wemoonyx.donarapp.home.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wemoonyx.donarapp.home.ui.components.HomeContent
import com.wemoonyx.donarapp.home.ui.components.HomeHeader

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        HomeHeader()
        HomeContent(Modifier.padding(16.dp))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}