package com.wemoonyx.donarapp.profile.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.outlined.ExitToApp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wemoonyx.donarapp.ui.theme.BluePrimary
import com.wemoonyx.donarapp.ui.theme.GrayPrimary
import com.wemoonyx.donarapp.ui.theme.interFontFamily

@Composable
fun ProfileTopAppBar(modifier: Modifier = Modifier, onLogoutClick: () -> Unit) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = "Back to home",
                tint = BluePrimary
            )
        }
        Text(
            text = "Mi perfil",
            fontFamily = interFontFamily,
            fontWeight = FontWeight.Bold,
            color = GrayPrimary
        )

        IconButton(onClick = { onLogoutClick() }) {
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.ExitToApp,
                contentDescription = "Exit",
                tint = BluePrimary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileTopAppBarPreview() {
    ProfileTopAppBar {}
}