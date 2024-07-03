package com.wemoonyx.donarapp.main.ui.navigation

sealed class ScreenRoutes(val route: String) {

    // Auth nav routes
    data object OnBoardingScreen: ScreenRoutes("onboarding_screen")
    data object LoginScreen: ScreenRoutes("login_screen")

    // Home nav routes
    data object HomeScreen: ScreenRoutes("home_screen")
    data object DonateScreen: ScreenRoutes("donate_screen")
    data object ProfileScreen: ScreenRoutes("profile_screen")

    // Donation nav routes
    data object DonateDetailScreen: ScreenRoutes("donate_detail_screen")

    // Nav Graphs
    data object MainNav: ScreenRoutes("main_nav")
    data object AuthNav: ScreenRoutes("auth_nav")
    data object DonateNav: ScreenRoutes("donate_nav")
}