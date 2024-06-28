package com.wemoonyx.donarapp.main.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wemoonyx.donarapp.ui.theme.BluePrimary
import com.wemoonyx.donarapp.ui.theme.BlueSecondary
import com.wemoonyx.donarapp.ui.theme.interFontFamily

@Composable
fun DonarBadge(modifier: Modifier = Modifier, text: String) {
    Box(
        modifier = modifier.clip(RoundedCornerShape(4.dp)).background(BlueSecondary)
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(2.dp),
            color = BluePrimary,
            fontFamily = interFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
        )
    }
}