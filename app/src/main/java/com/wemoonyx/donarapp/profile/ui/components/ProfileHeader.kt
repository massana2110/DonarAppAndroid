package com.wemoonyx.donarapp.profile.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wemoonyx.donarapp.R
import com.wemoonyx.donarapp.ui.theme.BluePrimary
import com.wemoonyx.donarapp.ui.theme.BlueTertiary
import com.wemoonyx.donarapp.ui.theme.GrayTertiary
import com.wemoonyx.donarapp.ui.theme.interFontFamily

@Composable
fun ProfileHeader(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(BlueTertiary)
    ) {
        TextButton(onClick = { /*TODO*/ }) {
            Text(
                text = "Editar",
                fontFamily = interFontFamily,
                fontWeight = FontWeight.Light,
                color = BluePrimary
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .size(96.dp)
                    .clip(CircleShape),
                painter = painterResource(id = R.drawable.photo_default),
                contentDescription = "Profile photo",
                contentScale = ContentScale.Crop
            )
            Text(
                text = "Vanessa Palma",
                modifier = Modifier.padding(vertical = 8.dp),
                fontFamily = interFontFamily,
                fontWeight = FontWeight.Bold,
                color = BluePrimary
            )
            Row(
                modifier = Modifier
                    .shadow(1.dp, RoundedCornerShape(8.dp), spotColor = Color(0xFFA6A6A6))
                    .clip(RoundedCornerShape(8.dp))
                    .background(GrayTertiary.copy(0.2f))
                    .absolutePadding(left = 8.dp, top = 8.dp, right = 8.dp, bottom = 8.dp)
            ) {
                Text(
                    text = "Tu saldo disponible: ",
                    fontFamily = interFontFamily
                )
                Text(
                    text = "$75.00",
                    fontFamily = interFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = BluePrimary
                )
            }
        }
    }
}

@Preview
@Composable
private fun ProfileHeaderPreview() {
    ProfileHeader()
}