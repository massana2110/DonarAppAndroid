package com.wemoonyx.donarapp.main.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.wemoonyx.donarapp.auth.ui.screens.LoginScreen
import com.wemoonyx.donarapp.donate.ui.screens.DonateScreen
import com.wemoonyx.donarapp.home.ui.screens.HomeScreen
import com.wemoonyx.donarapp.main.ui.screens.MainScreen
import com.wemoonyx.donarapp.onboarding.ui.OnboardingScreen
import com.wemoonyx.donarapp.profile.ui.screens.ProfileScreen
import com.wemoonyx.donarapp.ui.SetStatusBarColor

@Composable
fun AppNav() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ScreenRoutes.AuthNav.route) {
        // auth graph
        navigation(
            startDestination = ScreenRoutes.OnBoardingScreen.route,
            route = ScreenRoutes.AuthNav.route
        ) {
            composable(route = ScreenRoutes.OnBoardingScreen.route) {
                OnboardingScreen {
                    navController.navigate(route = ScreenRoutes.LoginScreen.route)
                }
                SetStatusBarColor(
                    statusBarColor = MaterialTheme.colorScheme.background,
                    navigationBarColor = null,
                )
            }

            composable(route = ScreenRoutes.LoginScreen.route) {
                LoginScreen(navController = navController)
                SetStatusBarColor(
                    statusBarColor = MaterialTheme.colorScheme.background,
                    navigationBarColor = null,
                )
            }
        }

        // main navigator
        composable(route = ScreenRoutes.MainNav.route) {
            MainScreen()
        }
    }
}

@Composable
fun MainNavGraph(
    navHostController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navHostController,
        route = ScreenRoutes.MainNav.route,
        startDestination = ScreenRoutes.HomeScreen.route
    ) {
        composable(
            route = ScreenRoutes.HomeScreen.route,
        ) {
            HomeScreen(modifier = Modifier.padding(paddingValues))
            SetStatusBarColor(
                statusBarColor = MaterialTheme.colorScheme.primary,
                navigationBarColor = null,
                isDarkIcons = true
            )
        }
        composable(
            route = ScreenRoutes.DonateScreen.route,
        ) {
            DonateScreen(modifier = Modifier.padding(paddingValues))
            SetStatusBarColor(
                statusBarColor = MaterialTheme.colorScheme.background,
                navigationBarColor = null,
            )
        }
        composable(
            route = ScreenRoutes.ProfileScreen.route,
        ) {
            ProfileScreen(modifier = Modifier.padding(paddingValues))
            SetStatusBarColor(
                statusBarColor = MaterialTheme.colorScheme.background,
                navigationBarColor = null,
            )
        }
    }
}