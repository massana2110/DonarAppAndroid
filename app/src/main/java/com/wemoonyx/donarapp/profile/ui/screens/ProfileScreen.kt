package com.wemoonyx.donarapp.profile.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wemoonyx.donarapp.profile.ui.components.ProfileDonationsList
import com.wemoonyx.donarapp.profile.ui.components.ProfileHeader
import com.wemoonyx.donarapp.profile.ui.components.ProfileLogoutModal
import com.wemoonyx.donarapp.profile.ui.components.ProfileTopAppBar

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    var isShowLogoutModal by remember {
        mutableStateOf(false)
    }

    Column(modifier = modifier) {
        ProfileTopAppBar {
            isShowLogoutModal = true
        }
        ProfileHeader()
        ProfileDonationsList(modifier = Modifier.padding(16.dp))

        // logout modal
        AnimatedVisibility(visible = isShowLogoutModal) {
            ProfileLogoutModal(onDismiss = { isShowLogoutModal = false }, onContinueClick = {})
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ProfileScreenPreview() {
    ProfileScreen()
}