package com.wemoonyx.donarapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.wemoonyx.donarapp.main.ui.navigation.AppNav
import com.wemoonyx.donarapp.ui.theme.DonarAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DonarAppTheme {
                // A surface container using the 'background' color from the theme
                AppNav()
            }
        }
    }
}