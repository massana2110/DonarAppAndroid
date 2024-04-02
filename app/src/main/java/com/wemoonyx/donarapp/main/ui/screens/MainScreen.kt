package com.wemoonyx.donarapp.main.ui.screens

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.wemoonyx.donarapp.ui.theme.BluePrimary
import com.wemoonyx.donarapp.ui.theme.LightGraySecondary
import com.wemoonyx.donarapp.ui.theme.interFontFamily

data class BottomAppBarOption(
    val title: String,
    val icon: ImageVector
)

private val listOptions = listOf(
    BottomAppBarOption("Inicio", Icons.Outlined.Home),
    BottomAppBarOption("Donar", Icons.Outlined.FavoriteBorder),
    BottomAppBarOption("Cuenta", Icons.Outlined.Person)
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    var indexSelected by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Color.White
            ) {
                listOptions.forEachIndexed { index, bottomAppBarOption ->
                    NavigationBarItem(
                        label = {
                            Text(
                                text = bottomAppBarOption.title,
                                fontFamily = interFontFamily,
                                fontWeight = FontWeight.Medium
                            )
                        },
                        selected = indexSelected == index,
                        onClick = { indexSelected = index },
                        icon = {
                            Icon(
                                imageVector = bottomAppBarOption.icon,
                                contentDescription = bottomAppBarOption.title
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = Color.White,
                            selectedIconColor = BluePrimary,
                            selectedTextColor = BluePrimary,
                            unselectedIconColor = LightGraySecondary,
                            unselectedTextColor = LightGraySecondary
                        )
                    )
                }
            }
        }
    ) {}
}

@Preview
@Composable
private fun MainBottomAppBarPreview() {
    MainScreen()
}