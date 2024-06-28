package com.wemoonyx.donarapp.main.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNav() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ScreenRoutes.OnBoardingScreen.route) {
        
    }
}