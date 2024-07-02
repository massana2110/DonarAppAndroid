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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.wemoonyx.donarapp.main.ui.navigation.MainNavGraph
import com.wemoonyx.donarapp.main.ui.navigation.ScreenRoutes
import com.wemoonyx.donarapp.ui.theme.BluePrimary
import com.wemoonyx.donarapp.ui.theme.LightGraySecondary
import com.wemoonyx.donarapp.ui.theme.interFontFamily

data class BottomAppBarOption(
    val title: String,
    val icon: ImageVector,
    val screen: ScreenRoutes
)

private val listOptions = listOf(
    BottomAppBarOption("Inicio", Icons.Outlined.Home, ScreenRoutes.HomeScreen),
    BottomAppBarOption("Donar", Icons.Outlined.FavoriteBorder, ScreenRoutes.DonateScreen),
    BottomAppBarOption("Cuenta", Icons.Outlined.Person, ScreenRoutes.ProfileScreen)
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination

            NavigationBar(
                containerColor = Color.White
            ) {
                listOptions.forEachIndexed { _, bottomAppBarOption ->
                    NavigationBarItem(
                        label = {
                            Text(
                                text = bottomAppBarOption.title,
                                fontFamily = interFontFamily,
                                fontWeight = FontWeight.Medium
                            )
                        },
                        selected = currentDestination?.hierarchy?.any { it.route == bottomAppBarOption.screen.route } == true,
                        onClick = {
                            navController.navigate(bottomAppBarOption.screen.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                        },
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
    ) {
        MainNavGraph(navHostController = navController, paddingValues = it)
    }
}

@Preview
@Composable
private fun MainBottomAppBarPreview() {
    MainScreen()
}