package com.wemoonyx.donarapp.main.ui.navigation

sealed class ScreenRoutes(val route: String) {

    // Auth nav routes
    data object OnBoardingScreen: ScreenRoutes("onboarding_screen")
    data object LoginScreen: ScreenRoutes("login_screen")

    // Home nav routes
    data object HomeScreen: ScreenRoutes("home_screen")
    data object DonateScreen: ScreenRoutes("donate_screen")
    data object ProfileScreen: ScreenRoutes("profile_screen")
}