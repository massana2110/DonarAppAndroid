package com.wemoonyx.donarapp.home.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.wemoonyx.donarapp.home.ui.components.HomeHeader

@Composable
fun HomeScreen() {
    Column {
        HomeHeader()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}