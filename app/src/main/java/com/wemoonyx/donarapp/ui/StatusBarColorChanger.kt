package com.wemoonyx.donarapp.ui

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Composable
fun SetStatusBarColor(
    statusBarColor: Color?,
    navigationBarColor: Color?,
    isDarkIcons: Boolean = isSystemInDarkTheme()
) {
    val window = (LocalContext.current as Activity).window
    val view = LocalView.current

    SideEffect {
        statusBarColor?.let {
            window.statusBarColor = it.toArgb()
        }

        navigationBarColor?.let {
            window.navigationBarColor = it.toArgb()
        }

        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !isDarkIcons
    }
}